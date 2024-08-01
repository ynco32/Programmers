L = int(input())
cake = [0 for _ in range(L+1)]

N = int(input())
people = [0 for _ in range(N)]

maxdiff = 0
diffIndex = 0
for person in range (N):
    p, k = map(int, input().split(" "))
    if k-p > maxdiff:
        maxdiff = k-p
        diffIndex = person
    for i in range(p, k+1):
        if cake[i] == 0:
            cake[i] = person+1
            people[person] += 1

print(diffIndex+1)
print(people.index(max(people))+1)