import sys
input = sys.stdin.readline

N = int(input())
dist = list(map(int ,input().split()))
price = list(map(int, input().split()))
oil = price[0]
total = 0

for i in range(N - 1):
    if price[i] < oil:
        oil = price[i]

    total += dist[i] * oil

print(total)