a, b = map(int, input().strip().split(' ')) 
#map(함수, 리스트/튜플) : 리스트의 요소를 지정된 함수로 처리
#strip() : 문자열 또는 공백을 모두 제거

for i in range(b):
    print('*'*a)