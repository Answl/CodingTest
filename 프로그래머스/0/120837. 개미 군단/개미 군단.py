def solution(hp):
    count = 0; answer = 0
    i = 5
    while hp != 0 :
        count, hp = hp // i, hp % i
        answer += count
        i -= 2
    return answer