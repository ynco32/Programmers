import math 

def is_prime_number(x):
    for i in range(2, int(math.sqrt(x))+1):
        if x % i == 0:
            return False 
    return True 

def solution(n, k):
    
    ans = 0
    div = 1
    
    while (n>0):
        ans += n%k *div
        n //= k
        div *= 10
    
    
    newans = str(ans)
    print(ans)
    nums = newans.split("0")
    print(nums)
    
    answer = 0
    isP = True
    
    for i in nums:
        if i == '' or i == '1':
            continue
        else:
            if is_prime_number(int(i)):
                answer+=1
    
    return answer