#7657
plate = input()
last = plate[0]
total = 10

for c in plate[1:]:
    if c == last:
        total += 5
    else:
        total += 10
        last = c

print(total)