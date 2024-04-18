n = int(input())
no = 0
yes = 0
while n>0:
    n-=1
    if int(input()) == 0:
        no+=1
    else:
        yes+=1

if no>yes:
    print("Junhee is not cute!")
else:
    print("Junhee is cute!")