def solution(s):
    answer = ''
    s_list = list(s.split(' '))
    
    for i in s_list :
        count = 0 #짝
        for n in range(len(i)):
            if count :
                answer += i[n].lower()
                count = 0
            else : 
                answer += i[n].upper()
                count = 1
        answer += ' '
    return answer[:-1]