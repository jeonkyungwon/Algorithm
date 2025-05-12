import sys
input = sys.stdin.readline

def check_rank(country):
    rank, cnt = 1, 1

    for i in range(N - 1):
        if country[i][0] == K:
            return rank
        if country[i][1] > country[i + 1][1]:
            rank += cnt
            cnt = 1
        elif country[i][1] == country[i + 1][1]:
            if country[i][2] > country[i + 1][2]:
                rank += cnt
                cnt = 1
            elif country[i][2] == country[i + 1][2]:
                if country[i][3] > country[i + 1][3]:
                    rank += cnt
                    cnt = 1
                elif country[i][3] == country[i + 1][3]:
                    cnt += 1

    return rank

N, K = map(int, input().split())
country = []

for _ in range(N):
    country.append(list(map(int, input().split())))

country.sort(key = lambda x: (-x[1], -x[2], -x[3]))

print(check_rank(country))