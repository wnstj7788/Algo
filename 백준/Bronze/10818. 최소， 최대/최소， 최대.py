a = int(input())

list_b = list(map(int, input().split()))

list_b.sort()

print(list_b[0],list_b[a-1])