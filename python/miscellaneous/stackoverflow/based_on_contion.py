# Original Question: https://stackoverflow.com/questions/76664017/create-multiple-calculated-fields-which-are-referenced-to-other-columns-based-o/76664150#76664150
import pandas as pd

data = {
    'ID': ['AA', 'BB'],
    'status': [False, True],
    'used': [3, 2]
}

df = pd.DataFrame(data)

df['new'] = df.apply(lambda row: row['used'] * 0.2 if row['status'] == False else row['used'] * 1, axis=1)

print(df)