def solution(s):
    answer = 0
    
    answer += isP(s)
    
    
    for i in range (len(s)-1):
        s = s[1:] + s[0]
        #print(s)
        answer += isP(s)
    
    
    return answer


def isP(str):
    ans = True
    
    list1 = []
    list2 = []
    list3 = []
    listT = []
    for c in str:
        if c == "(" or c == "[" or c == '{':
            listT.append(c)
        else:
            if c == ')':
                if len(listT) > 0 and listT[len(listT)-1] == "(":
                    listT.pop()
                else:
                    ans = False
                    break;
            elif c == ']':
                if len(listT) > 0 and listT[len(listT)-1] == "[":
                    listT.pop()
                else:
                    ans = False
                    break;
            elif c == '}':
                if len(listT) > 0 and listT[len(listT)-1] == "{":
                    listT.pop()
                else:
                    ans = False
                    break;
	
    if len(listT) != 0:
        ans = False
    
    if ans == True:
        #print("성공!")
        #print(str)
        return 1
    else:
        return 0