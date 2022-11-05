def filter_line(num):
    while True:
        line = (yield)
        if num in line:
            print(line)


cor = filter_line("33")
next(cor)
cor.send("Jessica, age:24")
cor.send("Marco, age:33")
cor.send("Filipe, age:55")