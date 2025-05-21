T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    farm = [list(map(int, input().strip())) for _ in range(N)]
    total = 0

    for i in range(N):
        if i <= N // 2:
            for j in range(N//2 - i, N//2 + i + 1):
                total+=farm[i][j]
        else:
            for j in range(i - N//2, N + N//2 - i):
                total+=farm[i][j]

    print('#%d' % test_case, total)