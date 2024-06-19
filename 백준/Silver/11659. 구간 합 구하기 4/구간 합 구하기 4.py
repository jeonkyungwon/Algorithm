import sys
input = sys.stdin.readline

N, M = map(int, input().split())
num = list(map(int, input().split()))
S = 0
sumArray = [0]

for i in num:
    S += i
    sumArray.append(S)

for _ in range(M):
    i, j = map(int, input().split())
    print(sumArray[j] - sumArray[i - 1])