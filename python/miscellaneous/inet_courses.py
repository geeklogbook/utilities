import requests as r
import urllib3


urllib3.disable_warnings()


def give_url(titulo, jurisdiccion):
    return "https://catalogo-inet.educacion.gob.ar/planes/{0}/{1}".format(titulo, jurisdiccion)

data = r.get("https://catalogo-inet.educacion.gob.ar/planes/110/10", verify=False)
data_json = data.json()
print(data)

# for titulo in range(1, 1000):
#     for jurisdiccion in range(1, 1000):
#         url = give_url(titulo, jurisdiccion)
#         result = r.get(url, verify=False).status_code
#         with open("url_with_information.csv", "w") as file:
#             file.write(url, result)
#         # print(url, result)git