import sys
input = sys.stdin.readline

N, K = map(int, input().split())
table = input().rstrip()
visited = [0 for _ in range(N)]
cnt = 0

for i in range(N):
    if table[i] == 'P':
        start = max(0, i - K)
        end = min(N, i + K + 1)

        for j in range(start, end):
            if table[j] == 'H' and visited[j] == 0:
                cnt += 1
                visited[j] = 1
                break

print(cnt)