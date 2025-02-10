def solution(sizes):
    answer = 0; max0 = 1; max1 = 1
    for s in sizes :
            if s[0] < s[1] :
                s[0], s[1] = s[1], s[0]
                
            if s[0] > max0 : 
                max0 = s[0]
            if s[1] > max1 :
                max1 = s[1]
    return max0 * max1