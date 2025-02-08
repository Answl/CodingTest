def solution(d, budget):
    answer = 0
    d_sum = 0
    d.sort()
    
    for num in d :
        if d_sum + num <= budget :
            d_sum += num
            answer += 1
        else :
            break
    return answer