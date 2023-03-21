H,M = map(int,input().split())
C = M-45
D = 60+M-45
E= H-1
F= 23

if M >= 45:
    print("{} {}".format(H,C))
elif H == 0 and M < 45:
    print("{} {}".format(F,D))
    
else:
    print("{} {}" .format(E,D))