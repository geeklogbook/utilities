from faker import Faker
import pandas as pd

fake = Faker()

class Person:

    def create_persona(size=3):
        output = pd.DataFrame()

        for _ in range(size):
            data = {
                'id': fake.unique.random_int(),
                'name': fake.name(),
                'email': fake.free_email(),
                'country': fake.country(),
                'city': fake.city(),
                'address': fake.street_address(),
                }

            generated = pd.DataFrame(data, index=[0])

            output = pd.concat([output, generated])
        return output