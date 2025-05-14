import sys
input = sys.stdin.readline

N = int(input())
a = []
for _ in range(N):
    a.append(list(input().rstrip()))

#심장 찾기
i, cnt = 0, 0
while cnt == 0:
    for j in range(N):
        if a[i][j] == '*':
            heart = [i + 1, j]
            cnt += 1
            break
    i += 1

# 양 팔 길이 구하기
left_arm, right_arm = 0, 0
for y in range(N):
    if y < heart[1] and a[heart[0]][y] == '*':
        left_arm += 1
    elif y > heart[1] and a[heart[0]][y] == '*':
        right_arm += 1

# 허리 길이 구하기
waist = 0
for x in range(heart[0] + 1, N):
    if a[x][heart[1]] == '*':
        waist += 1
    else:
        waist_end = [x - 1, heart[1]]
        break

# 양 다리 길이 구하기
left_leg, right_leg = 0, 0
for x in range(waist_end[0] + 1, N):
    if a[x][waist_end[1] - 1] == "*":
        left_leg += 1
    if a[x][waist_end[1] + 1] == "*":
        right_leg += 1

print(heart[0] + 1, heart[1] + 1)
print(left_arm, right_arm, waist, left_leg, right_leg)