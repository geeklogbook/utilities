from faker import Faker
from faker_clickstream import ClickstreamProvider

fake = Faker()
fake.add_provider(ClickstreamProvider)
fake.session_clickstream()

from faker import Faker
from faker_clickstream import ClickstreamProvider

fake = Faker()
fake.add_provider(ClickstreamProvider)
print(fake.session_clickstream())




