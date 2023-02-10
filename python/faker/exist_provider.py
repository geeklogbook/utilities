from faker import Faker
import random

fake = Faker()

def random_elements(size:int) -> list:
    methods_list = [method for method in dir(fake) if method.startswith('_') is False]
    random_elements = random.choices(methods_list, k=size)
    return random_elements
    
randoms = random_elements(4)


for elem in randoms:
    print(elem, type(elem))
    print(getattr(fake, elem)())
