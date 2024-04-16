t = int(input())


while(t>0):
    a, b = map(int, input().split())
    aa = a
    bb = b
    while bb != 0:
        r = aa%bb
        aa= bb
        bb = r
    print(int((a*b)/aa))
    t-=1