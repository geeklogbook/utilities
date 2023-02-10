def joint_print():
    while True:
        part_1 = (yield)
        part_2 = (yield)
        print("{} {}".format(part_1, part_2))


cor= joint_print()
next(cor)
cor.send("So Far")
cor.send("So Good")