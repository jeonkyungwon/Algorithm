from collections import Counter
import sys
input = sys.stdin.readline

N, score, P = map(int, input().split())
rank = list(map(int, input().split()))

if len(rank) == P:
    if score <= min(rank):
        print(-1)
    else:
        rank.pop()
        rank.append(score)
        rank.sort(reverse=True)
        answer = 1
        for i in range(len(rank)):
            if rank[i] == score:
                print(answer)
                break
            else:
                answer += 1
else:
    rank.append(score)
    rank.sort(reverse=True)

    answer = 1
    for i in range(len(rank)):
        if rank[i] == score:
            print(answer)
            break
        else:
            answer += 1