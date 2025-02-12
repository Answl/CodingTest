def solution(s, n):
    s2 = ''
    for i in s :
        if i == ' ':
            s2 += i
        elif ord('a')<= ord(i) <= ord('z') and ord(i)+n > ord('z') :
            s2 += chr(ord(i)+n-26)
        elif ord('A')<= ord(i) <= ord('Z') and ord(i)+n > ord('Z') :
            s2 += chr(ord(i)+n-26)
        else :
            s2 += chr(ord(i)+n)
    return s2