def fibo(n) :
    a = 0; b = 1
    for i in range(n-1):
        a, b = b, a+b
        
    return b
    
def solution(n):
    return fibo(n) % 1234567