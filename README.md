# CodingTest_Python
This is an auto push repository for Baekjoon Online Judge created with [BaekjoonHub](https://github.com/BaekjoonHub/BaekjoonHub).

# 중요
- 문자열 -> 리스트 : 문자열.**split**(sep='구분자', maxsplit=분할횟수)
- 리스트 -> 문자열 : '구분자'.**join**(리스트)

# 개념 정리
- **sum**(iterable) : iterable한 자료형을 받으며 numeric한 인자
- 수.**is_integer()** : 소수점 뒤에 모두 0이 있는 부동 소수점을 고려하여 정수인지 판단
- **map(함수, 리스트/튜플)** : 리스트의 요소를 지정된 함수로 처리
- **strip()** : 문자열 또는 공백을 모두 제거
- replace(원래, 대체) : **문자열**을 변경하는 함수
- count(찾는 요소) : **문자열, 리스트** 안에서 찾고싶은 문자의 개수
- **f**'**{}**'.. ex) f'문자열 {변수} 문자열'
- n진수 → 10진수 : int(string, base)
- 10진수 -> 2,8,16진수 : bin(), oct(), hex()
- 아스키코드 -> 숫자 : ord(), 숫자 -> 아스키코드 : chr()
- List: 순서가 있으며, 데이터(값) 중복 허용
- Set: 순서가 없으며, 데이터(값) 중복을 허용하지 않음
- 딕셔너리 !!! dict() {}로

# 문제 정리
- 최대공약수 :
  ``` python
  while b != 0 :
    (a ,b) = (b, a % b)
  ```
  
- 순열과 조합 :
  ``` python
  from itertools import combinations, permutations
    for i in permutations(리스트, 3) ...
    for i in combinations(리스트, 3) ...
  ```
