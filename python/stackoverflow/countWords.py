from collections import Counter
dict(Counter("hello"))

def counting(s):
    result = {}
    for c in s:
        if c not in result:
            result[c] = 0
        result[c] += 1
    return result

print(counting("Palindromo"))

def counting1(s):
    """
    Despite the fact the function work it has the problem that the algorimht is inneficient.
    Accordig to the Big O notation the complexitiy is O(n^2)
    """
    i = 1
    result = {}
    if len(s) == 0:
        return {}
    else:
        for c in s:
            resultnombres = 0
            for j in s:
                if j in c:
                    resultnombres += 1
            result[c] = resultnombres
    return result