import math

def solution(progresses, speeds):
    answer = []
    
    days = []
    release = []
    
    for i in range (len(speeds)):
        temp = 100
        temp -= progresses[i]
        temp = math.ceil(temp/speeds[i])
        days.append(temp)
    
    
    print(days)
    
    last = days[0]
    cnt = 0
    
    
    for d in days:
        if last >= d:
            
            cnt += 1
        else:
            answer.append(cnt)
            cnt = 1
            last = d
    
    answer.append(cnt)
    #print(answer)
    return answer