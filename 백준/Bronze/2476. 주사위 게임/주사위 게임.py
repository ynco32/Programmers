#2476
t = int(input())
total = []
while (t>0):
    t -= 1
    result = 0
    a, b, c = map(int, input().split())
    if a == b:
        if b == c:
            result = 10000 + a*1000
        else:
            result = 1000 + a*100
    elif a == c:
        result = 1000 + a*100
    elif b == c:
        result = 1000 + b*100
    else:
        result = max(a, b, c)*100
    #print(result)
    total.append(result)

total.sort(reverse=True)
print(total[0])