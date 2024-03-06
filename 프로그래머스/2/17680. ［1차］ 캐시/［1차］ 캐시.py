from collections import *

def solution(cacheSize, cities):
    answer = 0
    
    inCache = deque()
    
    
    for city in cities:
        city = city.lower()
        if city not in inCache:
            inCache.append(city)
            if len(inCache) > cacheSize:
                inCache.popleft()
            answer += 5
        else:
            answer += 1
            inCache.remove(city)
            inCache.append(city)
            
        
        
        
        
        
    
    
    return answer