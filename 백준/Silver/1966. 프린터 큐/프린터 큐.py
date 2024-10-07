from collections import deque
import sys
input = sys.stdin.readline

T = int(input())

for i in range(T):
    N, M = map(int, input().split())
    IM = deque(map(int, input().split()))
    cnt = 0

    while IM:
        if max(IM) > IM[0]:
            IM.append(IM.popleft())
            if M == 0:
                M = len(IM)
            M -= 1
        else:
            IM.popleft()
            cnt += 1
            M -= 1
            if M < 0:
                break

    print(cnt)