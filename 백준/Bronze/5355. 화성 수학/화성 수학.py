t = int(input())
while (t>0):
    list = input().split(" ")
    res = float(list[0])
    for c in list[1:]:
        if c == '@':
            res *= 3
        elif c == '%':
            res += 5
        elif c == '#':
            res -= 7
    print(format(res, ".2f"))
    t-=1


