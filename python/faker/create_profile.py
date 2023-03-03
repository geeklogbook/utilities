from fakeprofile import Person
from fakeprofile import BusinessPerson

df_person = Person.Person.create_persona(5)
print(df_person)

df_business_person = BusinessPerson.BusinessPerson.create_business_person(5)
print(df_business_person)