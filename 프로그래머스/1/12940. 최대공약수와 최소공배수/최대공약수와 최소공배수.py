def fun1(n, m): #최대공약수
    for i in range(1, n+1):
        if n%i==0 and m%i==0 :
            num1 = i
    return num1
    
def fun2(n, m, num1): #최소공배수
    return (n / num1) * (m / num1) * num1

def solution(n, m):
    answer = []; num1 = 0
    if n > m : n, m = m, n
    num1 = fun1(n,m)
    answer.append(num1); answer.append(fun2(n, m, num1))
    return answer