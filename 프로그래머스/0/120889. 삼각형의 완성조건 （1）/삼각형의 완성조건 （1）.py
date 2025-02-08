def solution(sides):
    answer = 0
    sides.sort()
    if sides[0]+sides[1]>sides[-1]:
        return 1
    return 2