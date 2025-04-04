import sys
input = sys.stdin.readline

N = int(input())
sizes = list(map(int, input().split()))
T, P = map(int, input().split())

answer_T = 0
answer_P = [N // P, N % P]

for size in sizes:
    answer_T += size // T
    if size % T > 0:
        answer_T += 1

print(answer_T)
print(*answer_P)