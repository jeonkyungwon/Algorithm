T = int(input())
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

for i in range(1, T + 1):
    N = int(input())
    snail = [[0] * N for _ in range(N)]
    x, y = 0, 0
    num = 1
    d = 0

    while num <= N * N:
        snail[x][y] = num

        if x + dx[d] < 0 or y + dy[d] < 0 or x + dx[d] >= N or y + dy[d] >= N or snail[x+dx[d]][y+dy[d]] != 0:
            d = (d + 1) % 4
        x += dx[d]
        y += dy[d]
        num += 1

    print("#%d" % i)
    for j in range(N):
        print(*snail[j])