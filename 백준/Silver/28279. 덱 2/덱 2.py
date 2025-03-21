from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
dq = deque()

for _ in range(N):
    cmd = list(input().split())

    if cmd[0] == "1":
        dq.appendleft(cmd[1])
    elif cmd[0] == "2":
        dq.append(cmd[1])
    elif cmd[0] == "3":
        if dq:
            print(dq.popleft())
        else:
            print(-1)
    elif cmd[0] == "4":
        if dq:
            print(dq.pop())
        else:
            print(-1)
    elif cmd[0] == "5":
        print(len(dq))
    elif cmd[0] == "6":
        if dq:
            print(0)
        else:
            print(1)
    elif cmd[0] == "7":
        if dq:
            print(dq[0])
        else:
            print(-1)
    elif cmd[0] == "8":
        if dq:
            print(dq[-1])
        else:
            print(-1)