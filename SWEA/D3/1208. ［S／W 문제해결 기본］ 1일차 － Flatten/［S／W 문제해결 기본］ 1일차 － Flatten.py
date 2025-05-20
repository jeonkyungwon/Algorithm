for i in range(1, 11):
    D = int(input())
    H = list(map(int, input().split()))
    cnt = 0

    while cnt < D and min(H) != max(H):
        H[H.index(max(H))] -= 1
        H[H.index(min(H))] += 1
        cnt += 1

    print('#%d' % i, max(H) - min(H))