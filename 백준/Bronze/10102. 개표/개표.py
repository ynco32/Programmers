v = int(input())
who = input()
a = 0
b = 0

for c in who:
    if c == "A":
        a+= 1
    else:
        b+=1

if a > b:
    print("A")
elif a == b:
    print("Tie")
else: 
    print("B")