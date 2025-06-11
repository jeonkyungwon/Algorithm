import sys
input = sys.stdin.readline

N = int(input())
standard = input().rstrip()
cnt = 0

for _ in range(N - 1):
    check = []
    copy_s = list(standard)
    word = input().rstrip()

    for w in word:
        if w not in copy_s:
            check.append(w)
        else:
            copy_s.remove(w)

    if len(check) <= 1 and len(copy_s) <= 1:
        cnt += 1

print(cnt)