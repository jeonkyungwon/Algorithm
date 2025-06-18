import sys
input = sys.stdin.readline

N, M = map(int, input().split())
T, P = [], []

for _ in range(N):
    title = list(input().split())
    T.append(title[0])
    P.append(int(title[1]))

for _ in range(M):
    s, e = 0, N - 1
    power = int(input())

    while s < e:
        mid = (s + e) // 2
        if power <= P[mid]:
            e = mid
        else:
            s = mid + 1

    print(T[s])