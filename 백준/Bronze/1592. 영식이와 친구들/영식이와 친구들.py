N, M, L = map(int, input().split(" "))
friends = [0 for _ in range (N)]
friends[0]+=1

idx = 0
count = 0
while friends[idx] < M:
    count+=1
    if friends[idx] % 2 == 1:
        if idx+L >= N: idx = idx + L - N
        else: idx += L
    else:
        if idx - L < 0: idx = idx -L + N
        else: idx -= L
    friends[idx] += 1
print(count)