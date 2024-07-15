num = []
sum = 0

for i in range(10):
    num.append(int(input()))

idx = 0;
while sum < 100:
    sum += num[idx]
    idx += 1
    if idx == 10 : break

idx -= 1
sum2 = sum - num[idx]


if (100-sum2) > (sum-100):
    print(sum)
elif (100-sum2) == (sum-100):
    print(sum)
else:
    print(sum2)