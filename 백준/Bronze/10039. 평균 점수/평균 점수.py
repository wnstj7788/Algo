res = 0
for _ in range(5):
    temp = int(input())
    if temp < 40:
        res +=40
    else:
        res += temp
print(res//5)
