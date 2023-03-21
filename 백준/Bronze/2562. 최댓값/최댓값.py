number = []

for i in range(9):
    a = int(input())
    number.append(a)
    
max_number = max(number)

print(max_number)
print(number.index(max(number))+1)