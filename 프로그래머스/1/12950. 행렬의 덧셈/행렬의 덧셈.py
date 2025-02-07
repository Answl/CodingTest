def solution(arr1, arr2):
    answer = []; answer2 = []
    for a1, a2 in zip(arr1, arr2):
        answer2 = []
        for aa1, aa2 in zip(a1, a2):
            answer2.append(aa1 + aa2)
        answer.append(answer2)
    return answer