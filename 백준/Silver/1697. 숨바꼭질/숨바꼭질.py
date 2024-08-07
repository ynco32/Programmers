from collections import deque

#입력받기
n, k = map(int, input().split())
visited = [False] * 100001

#bfs
def bfs(v):
    #초 카운트 초기화
    cnt= 0

    #deque에 수빈이 있는 위치와 그때 초를 저장
    q = deque([[v, cnt]])

    #deque가 
    while q:
        #위치와 초가 저장된 리스트를 pop 
        v = q.popleft()
        loc = v[0]
        cnt = v[1]

        if not visited[loc]:
            visited[loc] = True
            #동생이 있는 위치와 같으면 리턴
            if loc == k:
                return cnt

            #아니면 초를 추가
            cnt += 1

            #이동할 수 있는 방법 세가지 모두 범위 확인 후 데크에 저장
            if (loc*2) < 100001:
                q.append([loc*2, cnt])
            if (loc+1) < 100001:
                q.append([loc+1, cnt])
            if (loc-1) > -1:
                q.append([loc-1, cnt])

    return cnt


print(bfs(n))