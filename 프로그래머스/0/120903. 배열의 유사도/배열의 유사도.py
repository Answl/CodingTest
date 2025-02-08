def solution(s1, s2):
    answer = 0
    if len(s1) > len(s2) : s1, s2 = s2, s1
    
    for i in s1 :   
        if i in s2 :
            answer += 1
    return answer