b  = [i for i in range(1,31)]

for _ in range(28):
    y = int(input())
    b.remove(y)  

print(min(b))
print(max(b))