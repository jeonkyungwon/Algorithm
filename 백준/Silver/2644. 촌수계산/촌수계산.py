from collections import deque
import sys
input = sys.stdin.readline

def bfs(a):
     queue = deque([a])

     while queue:
         v = queue.popleft()

         for i in graph[v]:
             if visited[i] == 0:
                 visited[i] = visited[v] + 1
                 queue.append(i)

n = int(input())
a, b = map(int, input().split())
m = int(input())
graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)

for i in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

bfs(a)
print(visited[b]) if visited[b] > 0 else print(-1)