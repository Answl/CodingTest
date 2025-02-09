def solution(n):
    bin_n = bin(n)[2:]
    answer = n + 1
    while True :
        bin_answer = bin(answer)[2:]
        if bin_n.count('1') == bin_answer.count('1') :
            return answer
        answer += 1