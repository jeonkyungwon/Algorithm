for i in range(1, 11):
    N = int(input())
    H = list(map(int, input().split()))
    cnt = 0

    for j in range(2, N - 2):
        left = max(H[j - 2], H[j - 1])
        right = max(H[j + 2], H[j + 1])
        if left < H[j] and right < H[j]:
            cnt += H[j] - max(left, right)

    print('#%d' % i, cnt)