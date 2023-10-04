from selenium.webdriver.support.ui import Select
from selenium.webdriver.common.by import By
from selenium import webdriver
import time

provinces_blank = []
charge_blank = []

#Error: Capital Federal, Buenos Aires, Santiago del Estero
#provinces = ['CATAMARCA', 'CORDOBA', 'CORRIENTES', 'CHACO', 'CHUBUT', 'ENTRE RIOS', 'FORMOSA', 'JUJUY', 'LA PAMPA', 'LA RIOJA', 'MENDOZA', 'MISIONES', 'NEUQUEN', 'RIO NEGRO', 'SALTA', 'SAN JUAN', 'SAN LUIS', 'SANTA CRUZ', 'SANTA FE', 'TUCUMAN', 'TIERRA DEL FUEGO']
provinces = ['CAPITAL FEDERAL', 'BUENOS AIRES', 'SANTIAGO DEL ESTERO']
charge = ['DIPUTADO NACIONAL', 'PARLAMENTARIO MERCOSUR DN', 'PARLAMENTARIO MERCOSUR DR', 'PRESIDENTE Y VICE']

for c in charge:
    print(c)
    for province in provinces:
        print(province)
        driver = webdriver.Firefox()
        driver.get("https://www.padron.gob.ar/publica/")
        driver.find_element(By.ID, "site").click()
        time.sleep(5)
        select_site = Select(driver.find_element(By.ID, "site"))
        select_site.select_by_visible_text(province) # Select Distrito Electoral
        time.sleep(5)
        driver.find_element(By.ID, "tabgreen").click()
        time.sleep(10)
        driver.find_element(By.ID, "carg").click() # Select Consultar Cargo
        select_cargo = Select(driver.find_element(By.ID, "carg"))
        select_cargo.select_by_visible_text(c)
        driver.find_element(By.ID, "btnVer").click()
        time.sleep(10)
        driver.find_element(By.ID, "btnExcel").click() #"Export File
        time.sleep(10)
        driver.quit()


#GIVE ME A LIST WITH PROVINCES AND CHARGES
# driver = webdriver.Firefox()
# driver.get("https://www.padron.gob.ar/publica/")
# driver.find_element(By.ID, "site").click()
# time.sleep(5)
# select_site = Select(driver.find_element(By.ID, "site"))
# options = [option.text for option in select_site.options]
# for option in options:
#     provinces_blank.append(option)
# select_site.select_by_visible_text("CATAMARCA") # Select Distrito Electoral
# driver.find_element(By.ID, "tabgreen").click()
# driver.find_element(By.ID, "carg").click() # Select Consultar Cargo
# select_cargo = Select(driver.find_element(By.ID, "carg"))
# options_cargo = [option.text for option in select_cargo.options]
# for option in options_cargo:
#     charge_blank.append(option)
# print(charge_blank)
# print(provinces_blank)