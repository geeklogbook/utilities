from faker import Faker
import pandas as pd

fake = Faker()


def createDF(size):
    data = {'Name': [],
            'Email': [],
            'Address': [],
            'Phone': [],
            'Comment': []}

    for _ in range(size):
        data['Name'].append(fake.name())
        data['Email'].append(fake.free_email())
        data['Address'].append(fake.address())
        data['Phone'].append(fake.phone_number())
        data['Comment'].append(fake.text())

    return pd.DataFrame(data)


df_example = print(createDF(5))
