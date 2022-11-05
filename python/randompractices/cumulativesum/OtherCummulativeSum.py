def minStart(arr):
    # Write your code here
    b = [sum(arr[0:x:1]) for x in range(len(arr)+1)][1:]
    tot = b[-1]
    return tot

a = [10, -5, 4, -2, 3, 1, -1, -6, -1, 0, 5]
print(minStart(a))
