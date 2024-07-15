N = int(input())-1

cnt = 1
while N>0:
    N -= cnt*6
    cnt += 1

print(cnt)