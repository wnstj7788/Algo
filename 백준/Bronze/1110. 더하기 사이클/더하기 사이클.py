num = int(input())
two_num =0
re_num =0 
counter=1
Early = num
if not (0 <= num <= 99):
    exit()

while True:
    two_num = num % 10
    num = int(num / 10)
    re_num = num + two_num
    num = (two_num*10) + re_num %10


    if (Early == num):
        break
    else:
        counter += 1
print(counter)