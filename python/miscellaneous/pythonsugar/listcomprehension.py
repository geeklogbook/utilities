# Declarative Form: [expression for item in list if conditional]

#Normal Loop
squares = []
for i in range(10):
    squares.append(i * i)
print(squares)

#Map

txns = [10, 20, 30, 40, 50, 60]
TAX_RATE = .08


def get_price_with_tax(txn):
    return txn * (1 + TAX_RATE)

final_prices = map(get_price_with_tax, txns)
print(list(final_prices))

squares = [i * i for i in range(10)]
print(squares)

sentence = 'the rocket came back from mars'
vowels = [i for i in sentence if i in 'aeiou']
print(vowels)