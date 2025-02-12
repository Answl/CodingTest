def solution(s):
    answer = ''; result = []; count = 0
    for i in s :
        if i not in answer :
            result.append(-1)
        else :
            result.append(count - answer.index(i))
            answer = answer.replace(i, ' ')
        count += 1
        answer += i
              
    return result