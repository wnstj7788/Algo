total = int(input())

line = int(input())

total_cost = 0 

for i in range(line):
    a , b= map(int, input().split())
    result = a * b
    total_cost = total_cost + result

if total == total_cost :
    print('Yes')
else:
    print('No')