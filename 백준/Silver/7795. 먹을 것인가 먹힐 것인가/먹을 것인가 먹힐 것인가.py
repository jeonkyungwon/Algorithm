import sys
input = sys.stdin.readline

def check_size(a, b, st):
    s, e = 0, st

    while s < e:
        mid = (s + e) // 2
        if b[mid] < a:
            s = mid + 1
        else:
            e = mid

    return s

T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    A.sort(reverse=True)
    B.sort()
    std = M
    cnt = 0

    for i in range(N):
        std = check_size(A[i], B, std)
        cnt += std

    print(cnt)