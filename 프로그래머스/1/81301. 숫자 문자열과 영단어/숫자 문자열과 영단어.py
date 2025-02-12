def solution(s):
    answer = ''
    dict_s = {'zero':0, 'one' : 1, 'two' : 2, 'three' : 3, 'four' : 4, 'five' : 5, 'six' : 6, 'seven' : 7, 'eight': 8, 'nine' : 9}
    for i in dict_s :
        if i in s :
            s = s.replace(i, str(dict_s[i]))
    return int(s)