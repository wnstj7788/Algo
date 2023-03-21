S = list(map(int,input().split()))

S.sort()


if S[0] == S[1] == S[2] :
    result = 10000 + (S[0] * 1000 )
    print(result)
elif S[0] == S[1] or S[0] == S[2]:
    result = 1000 + (S[0] * 100)
    print(result)
elif S[1] == S[2] or S[0] == S[2] :
    result = 1000 + (S[2] * 100)
    print(result)
else:
    result = S[2] * 100
    print(result)