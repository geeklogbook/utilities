# https://stackoverflow.com/questions/76664249/pandas-how-to-find-data-from-last-filled-in-column/76664365#76664365
import pandas as pd
import numpy as np

def extract_lowest_level(df):
    result_df = df.copy()
    result_df = df.replace(0, np.nan)
    result_df['Desired Output'] = result_df.apply(lambda row: row[row.last_valid_index()], axis=1)
    result_df = result_df.fillna(0)
    return result_df

data = {
    'ID': [1, 2, 3, 4],
    'Lvl 1': ['aaa', 'aaa', 'aaa', 'aaa'],
    'Lvl 2': [0, 'bbb', 'bbb', 'bbb'],
    'Lvl 3': [0, 'ccc', 'ccc', 'ccc'],
    'Lvl 4': [0, 0, 0, 'ddd']
}

df = pd.DataFrame(data)
print(df)

result_df = extract_lowest_level(df)

print(result_df)