def solution(clothes):
    _dict = {}

    for c in clothes:
        _dict[c[1]] = []

    for c in clothes:
        _dict[c[1]].append(c[0])
    
    # for c in clothes:
    #     clo[c[1]] = c[0]

        
    print(_dict)
    res = 1
    for v in _dict.values():
        res *= (len(v) + 1)
        
    
    res -=1 
    return res