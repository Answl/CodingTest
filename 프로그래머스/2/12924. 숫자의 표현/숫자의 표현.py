def fun(n):
    if n-0.5 == int(n) :
        return 'num05'

    
    if n%2==0 :
        return 'even'
    else :
        return 'odd'

def solution(n):
    answer = 0;
    
    if fun(n) == 'odd':
        if n == 1 :
            return 1
        
        for i in range(1, n):
            if i == 2 :
                answer += 1
            
            if fun(i)=='odd' and n%i==0 :
                answer += 1
                
    elif fun(n) == 'even' :
        for i in range(1, n):
            if i == 1 :
                answer += 1
            
            if fun(i)=='even' and fun(n/i)=='num05':
                answer += 1
    return answer