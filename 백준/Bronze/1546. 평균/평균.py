n = int(input())

s = list(map(int,input().split()))

m = max(s)

r = []

for i in s:
   f = i / m * 100
   r.append(f)

print(sum(r) / n)
