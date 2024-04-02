import os
import pandas as pd

def combine_csv_files(root_folder):
    all_data = pd.DataFrame()

    for dirpath, dirnames, filenames in os.walk(root_folder):
        for filename in filenames:
            if filename.endswith('.csv'):
                file_path = os.path.join(dirpath, filename)
                data = pd.read_csv(file_path)
                all_data = pd.concat([all_data, data], ignore_index=True)

    return all_data

root_folder = ""
combined_data = combine_csv_files(root_folder)

combined_data.to_csv(root_folder + "allOutputs.csv", encoding='utf-8-sig', index=False)