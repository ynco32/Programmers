t = int(input())
while t>0:
    t-=1
    r, e, c = map(int, input().split())
    if r > e-c:
        print("do not advertise")
    elif r == e-c:
        print("does not matter")
    else:
        print("advertise")