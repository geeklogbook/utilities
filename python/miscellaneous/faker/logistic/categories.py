from faker import Faker
import pandas as pd

fake = Faker()

def random_categories() -> list:
    categories_names = [
        'Productos Químicos',
        'Maquinaria y Equipos',
        'Electrónica',
        'Textiles y Prendas de Vestir',
        'Metales y Minerales',
        'Productos Farmacéuticos',
        'Plásticos y Polímeros',
        'Automóviles y Vehículos',
        'Productos Electrónicos de Consumo',
        'Equipamiento Médico'
    ]
    
    category_list = []

    for i in range(len(categories_names)):
        category_id = i + 1
        category = {'id': category_id, 'name': categories_names[i]}
        category_list.append(category)

    return category_list
    
result = random_categories()
for category in result:
    print(category)

import csv

def save_to_csv(data_list, file_path):
    keys = data_list[0].keys() if data_list else []
    
    with open(file_path, 'w', newline='', encoding='utf-8') as csvfile:
        writer = csv.DictWriter(csvfile, fieldnames=keys)
        writer.writeheader()
        writer.writerows(data_list)

save_to_csv(result, "prueva.csv")