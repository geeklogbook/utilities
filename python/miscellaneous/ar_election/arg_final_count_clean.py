import pandas as pd
import datetime
import xlrd
import os

path_output = "C:\\Users\\jchemile\\Documents\\geeklogbook\\utilities\\datasources\\ar_elections\\clean\\presidente_y_vice\\"

def _election_information(sheet):
    # Access cell E4 and get its value
    election_date = sheet.cell_value(3, 4).split(':')[1].strip()  # Rows and columns are 0-indexed
    election_date = datetime.datetime.strptime(election_date, "%d/%m/%Y").strftime("%Y%m%d")
    district_name = sheet.cell_value(5, 0).split(':')[1].strip().capitalize()  # Rows and columns are 0-indexed
    district_number = path_input.rsplit('\\', 1)[1].split('.')[0].rsplit("_",1)[1]
    charge = sheet.cell_value(6, 0).split(':')[1].strip().capitalize()  # Rows and columns are 0-indexed
    return [election_date, district_number, district_name, charge]

def _find_row(sheet, target_value):
    """
    Find the row index where the target value "Agrupacion politica" is located.

    Args:
        sheet (xlrd.sheet.Sheet): The Excel sheet to search.

    Returns:
        int: The 1-indexed row where the target value is found. Returns None if not found.
    """
    for row_index in range(sheet.nrows):
        for col_index in range(sheet.ncols):
            cell_value = sheet.cell_value(row_index, col_index)
            if cell_value == target_value:
                return row_index + 1  # Adjust to 1-indexed
    return None

def _data_rows(sheet):
    # Define the range
    start_row = _find_row(sheet, "Agrupación Política")  # Row 16 (0-indexed)
    end_row = _find_row(sheet, "    TOTALES")    # Row 69 (0-indexed)
    start_col = 0   # Column B (0-indexed)
    end_col = 5     # Column F (0-indexed)

    rows = []

    # Iterate over the range
    for row_index in range(start_row, end_row + 1):
        row_values = []  # Initialize a list for the values in this row
        for col_index in range(start_col, end_col + 1):
            if row_index < sheet.nrows and col_index < sheet.ncols:
                cell_value = sheet.cell_value(row_index, col_index)
                row_values.append(cell_value)  
        rows.append(row_values)
    return rows

def _get_excel_files_with_full_path(path):
    excel_files = [os.path.join(path, f) for f in os.listdir(path) if f.endswith('.xlsx') or f.endswith('.xls')]
    return excel_files

path_root = 'C:\\Users\\jchemile\\Documents\\geeklogbook\\utilities\datasources\\ar_elections\\raw\\presidente_y_vice\\'
path_files = _get_excel_files_with_full_path(path_root)

for path_input in path_files:
    print(path_input)
    # Open workbook 
    workbook = xlrd.open_workbook(path_input, ignore_workbook_corruption=True)
    # Select the first sheet
    sheet = workbook.sheet_by_index(0)

    election_date, district_number, district_name, charge = _election_information(sheet)
    print(election_date, district_name, district_number,  charge)
    print()

    rows = _data_rows(sheet)
    # Define column names
    column_names = ["Numero de Lista", "Agrupación Política", "Votos", "Votos General [%]", "Votos Válidos [%]", "Votos Afirmativos [%]"]

    # Create a DataFrame
    df = pd.DataFrame(rows, columns=column_names)
    df = df.dropna(axis=0, how='all')
    df['Numero de Lista'] = df['Numero de Lista'].apply(lambda x: str(int(float(x))).strip() if '.' in str(x).strip() else str(x).strip())
    df['Votos'] = df['Votos'].apply(lambda x: str(int(float(x))) if '.' in str(x) else str(x))
    df["distrito"] = district_name
    df["cargo"] = charge
    print(df[['Numero de Lista', 'Agrupación Política', 'Votos']])

    # Create Agrupacion Politica
    df_agrupacion = df[df["Votos"].isna() | (df["Votos"] == "")][['Numero de Lista', 'Agrupación Política']]
    #print(df_agrupacion)

    result_df = pd.merge(df, df_agrupacion, on='Numero de Lista', how='left')
    result_df = result_df[result_df["Votos"].notna() & (result_df["Votos"] != "")]
    result_df = result_df[['distrito', 'cargo', 'Agrupación Política_y', 'Agrupación Política_x', 'Votos']]
    result_df = result_df.rename(columns= {"Agrupación Política_y": "agrupacion_politica", 
                                "Agrupación Política_x": 
                                "lista", 
                                "Votos":"votos"})
    result_df['lista'] = result_df['lista'].str.strip()

    # Get the "votos" for "VOTOS NULOS
    votos_nulos = result_df[result_df['lista'] == 'VOTOS NULOS']['votos'].values
    if len(votos_nulos) == 0:
        votos_nulos = 0
    else:
        votos_nulos = votos_nulos[0]

    # Get the "votos" for "VOTOS RECURRIDOS"
    votos_recurridos = result_df[result_df['lista'] == 'VOTOS RECURRIDOS']['votos'].values
    if len(votos_recurridos) == 0:
        votos_recurridos = 0
    else:
        votos_recurridos = votos_recurridos[0]

    # Get the "votos" for "VOTOS IMPUGNADOS"
    votos_impugnados = result_df[result_df['lista'] == 'VOTOS IMPUGNADOS']['votos'].values
    if len(votos_impugnados) == 0:
        votos_impugnados = 0
    else:
        votos_impugnados = votos_impugnados[0]
    votos_en_blanco = result_df[result_df['lista'] == 'VOTOS EN BLANCO']['votos'].values[0]
    votos_totales = result_df[result_df['lista'] == 'TOTALES']['votos'].values[0]
    result_df = result_df[result_df["agrupacion_politica"].notna()]

    new_rows = [
        [district_name, charge, 'VOTOS NULOS', 'VOTOS NULOS', int(votos_nulos)],
        [district_name, charge, 'VOTOS RECURRIDOS', 'VOTOS RECURRIDOS', int(votos_recurridos)],
        [district_name, charge, 'VOTOS IMPUGNADOS', 'VOTOS IMPUGNADOS', int(votos_impugnados)],
        [district_name, charge, 'VOTOS BLANCO', 'VOTOS EN BLANCO', int(votos_en_blanco)], 
        [district_name, charge, 'VOTOS TOTALES', 'VOTOS TOTALES', int(votos_totales)] 
    ]

    new_df = pd.DataFrame(new_rows, columns=result_df.columns)
    result_df = pd.concat([result_df, new_df], ignore_index=True)

    #print(result_df.sort_values(by="agrupacion_politica"))
    file_name_df = path_output + "clean_" + charge + "_DIST_" +district_number + "_" + election_date + "_ " +".csv"
    result_df.to_csv(file_name_df, encoding='utf-8-sig', index=False)