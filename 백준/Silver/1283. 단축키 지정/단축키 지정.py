import sys
input = sys.stdin.readline

N = int(input())
key = []

for _ in range(N):
    ch = input().rstrip()
    check = [0]
    end = 0
    # 단어의 첫 글자 찾기
    for i in range(1, len(ch)):
        if ch[i] == ' ':
            check.append(i + 1)
    # 단어의 첫 글자 확인
    for i in check:
        if ch[i] not in key:
            key.append(ch[i].upper())
            key.append(ch[i].lower())
            print(ch[:i], "[", ch[i], "]", ch[i + 1:], sep='')
            end += 1
            break
    # 모든 단어의 첫 글자가 이미 지정이 되어있다면
    if end == 0:
        for i in range(1, len(ch)):
            if ch[i] != " " and ch[i] not in key:
                key.append(ch[i].upper())
                key.append(ch[i].lower())
                print(ch[:i], "[", ch[i], "]", ch[i + 1:], sep='')
                end += 1
                break
    # 어떠한 것도 단축키로 지정할 수 없다면
    if end == 0:
        print(ch)