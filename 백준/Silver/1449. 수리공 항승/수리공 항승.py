n, l = map(int, input().split())
water = list(map(int, input().split()))

water.sort()
start = water[0]
cnt = 1

for loc in water[1:]:
    if loc in range(start, start+l):
        continue
    else:
        start = loc
        cnt += 1

print(cnt)