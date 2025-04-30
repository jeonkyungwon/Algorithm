from collections import Counter
import sys
input = sys.stdin.readline

N, score, P = map(int, input().split())
rank = list(map(int, input().split()))

if len(rank) == P and score <= min(rank):
        print(-1)

else:
    rank.append(score)
    rank.sort(reverse=True)
    if len(rank) > P:
        rank.pop()

    answer = 1
    for i in range(len(rank)):
        if rank[i] == score:
            print(answer)
            break
        else:
            answer += 1