import sys
input = sys.stdin.readline

N, M = map(int, input().split())
cards = list(map(int, input().split()))
max_per = 0

for i in range(N):
    for j in range(i + 1, N):
        for k in range(j + 1, N):
            if cards[i] + cards[j] + cards[k] <= M:
                max_per = max(max_per, cards[i] + cards[j] + cards[k])

print(max_per)