t = int(input())
dx = [-1, 1, 0, 0]
dy = [0,0,-1,1]

def bfs(a,b):
    queue=[(a,b)]
    ground[a][b] = 0

    while queue:
        a, b =queue.pop(0)
        
        for l in range(4):
            nx = a+dx[l]
            ny = b +dy[l]

            if nx < 0 or nx >= m or ny < 0 or ny >=n:
                continue
            if ground[nx][ny] == 1:
                queue.append((nx,ny))
                ground[nx][ny] = 0


while (t):
    t-=1
    m, n, k = map(int, input().split())
    ground = [[0]*(n) for _ in range(m)]
    cnt = 0
    while (k):
        k-=1
        x, y = map(int, input().split())
        ground[x][y] = 1
    
    for i in range(m):
        for j in range(n):
            if ground[i][j] == 1:
                bfs(i,j)
                cnt += 1
    print(cnt)
