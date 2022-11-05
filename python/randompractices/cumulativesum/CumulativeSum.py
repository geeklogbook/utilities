def running_sum(a):
    aux = 0
    for item in a:
        aux += item
        print(item, aux)
        print(aux - item)

a = [10, -5, 4, -2, 3, 1, -1, -6, -1, 0, 5]
b = [sum(a[0:x:1]) for x in range(len(a)+1)][1:]
tot = b[-1]
print(tot)