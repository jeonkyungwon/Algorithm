import sys
input = sys.stdin.readline

P = int(input())

for _ in range(P):
    T = list(map(int, input().split()))
    line = [T[1]]
    cnt = 0
    for i in range(2, len(T)):
        if max(line) > T[i]:
            for j in range(len(line)):
                if line[j] > T[i]:
                    cnt += len(line) - j
                    line = line[:j] + [T[i]] + line[j:]
                    break
        else:
            line.append(T[i])

    print(T[0], cnt)