from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
import time

driver = webdriver.Firefox()
driver.get("https://www.padron.gob.ar/publica/")


driver.find_element(By.ID, "site").click()
select_site = Select(driver.find_element(By.ID, "site"))
#select_site.select_by_value("03   ")
select_site.select_by_visible_text("CATAMARCA")
driver.find_element(By.ID, "tabgreen").click()
driver.find_element(By.ID, "carg").click()
select_cargo = Select(driver.find_element(By.ID, "carg"))
select_cargo.select_by_index(1)
driver.find_element(By.ID, "btnVer").click()
time.sleep(10)
driver.find_element(By.ID, "btnExcel").click()