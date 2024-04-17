k, n, m = map(int, input().split())
total = k *n
ans = total - m

if ans > 0:
    print(ans)
else:
    print(0)