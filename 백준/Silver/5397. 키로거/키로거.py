from collections import deque
import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    left = deque()
    right = deque()
    pw = input().rstrip()

    for ch in pw:
        if ch == '<':
            if left:
                right.appendleft(left.pop())
        elif ch == '>':
            if right:
                left.append(right.popleft())
        elif ch == '-':
            if left:
                left.pop()
        else:
            left.append(ch)

    print("".join(left) + "".join(right))