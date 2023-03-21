a = []


for i in range(10):
    b = int(input())
    c = b % 42
    a.append(c)

print(len(set(a)))   