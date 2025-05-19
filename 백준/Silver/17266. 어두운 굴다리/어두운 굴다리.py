import sys
input = sys.stdin.readline

def is_possible(h):
    prev = 0
    for x in lights:
        if x - h > prev:
            return False
        prev = x + h

    return prev >= N

N = int(input())
M = int(input())
lights = list(map(int, input().split()))

start, end = 0, N
answer = N

while start <= end:
    mid = (start + end) // 2
    if is_possible(mid):
        answer = mid
        end = mid - 1
    else:
        start = mid + 1

print(answer)