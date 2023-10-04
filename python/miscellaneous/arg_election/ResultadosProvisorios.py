import csv

file_path = "C:\\Users\\jchemile\\Documents\\geeklogbook\\utilities\\datasources\\2023_PASO\\ResultadosElectorales.csv"
ouptput_path = "C:\\Users\\jchemile\\Documents\\geeklogbook\\utilities\\datasources\\2023_PASO\\"

file = open(file_path, 'r', encoding="utf8")
reader = csv.reader(file)

header = next(csv.reader(open(file_path, 'r', encoding="utf8")))

with open(ouptput_path + "buenosaires.csv", "w", encoding="utf8", newline='') as f:
    write = csv.writer(f)
    write.writerow(header)
    for row in reader:
        if row[4] == '2':
            write.writerow(row)


