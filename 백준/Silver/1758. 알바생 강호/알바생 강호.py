import sys
input = sys.stdin.readline

N = int(input())
tip = [int(input()) for i in range(N)]
tip.sort(reverse=True)
result, order = 0, 0

for i in tip:
    if i - order > 0:
        result += i - order

    order += 1

print(result)