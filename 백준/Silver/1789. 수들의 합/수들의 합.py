a = int(input())
cnt = 0
minus = 1
while (a>0):
    a -= minus
    minus += 1
    cnt+=1

if (a==0): print(cnt)
else: print(cnt-1)