n = int(input())
data = list(map(int, input().split()))
data.sort(reverse=True)

cnt = 0
for i in range(n):
  tmp = (i+1) * data[i]
  cnt = cnt + tmp


print(cnt)

