# 출력하기
print('chuwg')
na = 'cㅠc'

print(na[1])  # 원하는 것만 출략

# List와 Dictionary

# List
중고차 = ['k5', 'white', 5000]
print(중고차)  # 전체 출력
print(중고차[1])  # List 원하는 것만 출력하기
중고차[1] = 'K7'  # List 값 수정하기
print(중고차[1])

# Dictionary
중고차2 = {
    'brand': 'BMW',
    'model': '520d'
}
# Dictionary 딕셔너리에 자료를 저장할 때 왼쪽에 이름을 달아야 한다.
print(중고차2)  # Dictionary 전체 출력
print(중고차2['brand'])  # Dictionary 원하는 값만 출력
중고차2['brand'] = 'SM'  # Dictionary 값 수정하기
print(중고차2['brand'])

# Dictionary 자료형을 사람들이 좋아함.
# 나중에 출력하기에 편하기 때문.
# 엑셀에 컬럼 같이 때문에 자주 사용.

# 조건문
재고량 = 10
# 조건문 작성방법
# if (조건식):
#   실행할 코드
if (재고량 > 0):  # 부등호, 등호 자주 사용. 조건이 맞을 때만 코드 실행.
    print('지금 주문 가능합니다.')

중고차재고 = ['k5', 'k7', 'BMW', 'SM']
if 'k8' in 중고차재고:  # k5가 중고차재고 안에 있는가?
    print('지금 주문 가능합니다!')  # 조건식이 맞을 때 실행
# 조건식에는 in 문법도 자주 사용.
elif 'k7' in 중고차재고:
    print('k8은 없지만 비슷한 스타일의 k7은 있습니다.')
else:
    print('지금은 주문이 불가능합니다.')
# if 조건문은 어떤 코드를 조건이 맞을 때만 실행시키고 싶은 경우 사용.

# for 반복문 : 노가다를 줄일 때 사용.
# 1. 코드 단순 반복할 때 사용
# 2. List 자료 하나씩 출력할 때 사용
for i in range(0, 2):  # range 값 만큼 반복
    print('BMW 있어요!')

중고차들 = ['K5', 'K7', 'BMW', 'Ford']
for i in 중고차들:  # List 를 넣는 것도 가능. List 자료 수 만큼 코드 반복.
    print(i)

# def 함수 문법
# 함수 문법은 언제 사용?
# 1. 긴 코드를 짧은 단어로 축약할 때 사용. if 나 for문도 사용 가능
# 2. 마법의 모자 만들기 가능 = 무엇을 집어 넣으면 다른게 나오는 변환기
# 함수는 위에 만들어 놓아야 밑에 가서 함수 쓰기 가능.
# 3. 함수 실행하고 나서 return -> 남길 자료. (옵션)


def 인사():
    print('안녕하세요!!')
    print('홍길동입니다.')
    print('38세 입니다.')


인사()


def 모자(구멍):
    print(구멍 + 1)


모자(2)  # 구멍에 넣어준 2에다가 + 1 해서 결과값은 3


def 함수():
    return 10


print(함수())