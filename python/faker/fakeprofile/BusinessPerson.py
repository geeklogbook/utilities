from faker import Faker
import pandas as pd

fake = Faker()

class BusinessPerson:

    def create_business_person(size=3):
        output = pd.DataFrame()

        for _ in range(size):
            data = {
                # From -> https://faker.readthedocs.io/en/master/providers/faker.providers.date_time.html
                'join_date': fake.date(),
                'business_email': fake.free_email(),
                'role': fake.name(),
                }

            generated = pd.DataFrame(data, index=[0])

            output = pd.concat([output, generated])
        return output