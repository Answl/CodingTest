def fun(n): #앞뒤 반전(3진법)
    n_3 = 0; num3= ''
    while n != 0 :
        n, n_3 = n//3, n%3
        num3 += str(n_3)
    return num3
    
def solution(n):
    return int(fun(n), 3)