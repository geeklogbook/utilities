from faker import Faker
import pandas as pd

fake = Faker()

class Person:

    def create_persona(size=3):
        output = pd.DataFrame()

        for _ in range(size):
            data = {
                # From -> https://faker.readthedocs.io/en/master/providers/faker.providers.person.html
                'first_name': fake.first_name(),
                'last_name': fake.last_name(),
                # From -> https://faker.readthedocs.io/en/master/providers/faker.providers.date_time.html
                'birth_date': fake.date(),
                'email': fake.free_email(),
                'address': fake.street_address(),
                'city': fake.city(),
                'country': fake.country(),
                }

            generated = pd.DataFrame(data, index=[0])

            output = pd.concat([output, generated])
        return output