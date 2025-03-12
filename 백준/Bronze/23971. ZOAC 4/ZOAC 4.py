import sys
input = sys.stdin.readline

H, W, N, M = map(int, input().split())
i, j = 0, 0
x, y = 1, 1

while 1:
    i += N + 1
    if i >= H:
        break
    x += 1

while 1:
    j += M + 1
    if j >= W:
        break
    y += 1

print(x * y)