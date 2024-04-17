sum = 0

for i in range(5):
    temp = int(input())
    if temp < 40:
        sum += 40
    else:   
        sum+=temp

print(int(sum/5))
