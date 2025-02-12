def solution(brown, yellow):
    answer = []
    tile = brown + yellow 
    for i in range(tile, 2, -1) : #i는 가로
        if tile % i==0 and yellow % (i-2)==0 :
            answer = [i, tile // i]
            return answer
        