david={'hair':'brown','age':42}

print(david)            # {'hair': 'brown', 'age': 42}
values = david.values() #dict_values(['brown', 42])
keys = david.keys()     #dict_keys(['hair', 'age'])
items = david.items()   #dict_items([('hair', 'brown'), ('age', 42)])

#Print the values of the dictionary
print("Values: ", values)
for v in values:
    print(v)

#Print the keys of the dictionary
print("Keys: ", keys)
for k in keys:
    print(k)

#Print the items of the dictionary
print("Items: ", items)
for i in items:
    print(i)