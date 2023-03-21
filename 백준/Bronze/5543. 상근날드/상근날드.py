bu = 2000
dr = 2000
for _ in range(3):
    temp = int(input())
    bu = min(bu,temp)
for _ in range(2):
    temp = int(input())
    dr = min(dr,temp)
print(bu+dr -50 )
