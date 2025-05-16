import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    t = list(map(int, input().split()))
    team = {}

    # 각 팀의 선수 카운트
    for i in t:
        if i not in team:
            team[i] = 1
        else:
            team[i] += 1

    # 선수가 6명 이상인 팀 점수 and 5번 째 선수 점수 계산
    result, cnt = {}, {}
    rest = []
    score = 1
    for i in t:
        if team[i] == 6:
            if i not in result:
                result[i] = score
                cnt[i] = 1
            else:
                if cnt[i] < 4:
                    result[i] += score
                    cnt[i] += 1
                elif cnt[i] == 4:
                    rest.append(i)
                    cnt[i] += 1
            score += 1

    # 우승 팀 출력
    win_score, win = result[rest[0]], rest[0]
    check = []
    for i in rest:
        if result[i] < win_score:
            win_score = result[i]
            win = i
            check = [i]
        elif result[i] == win_score:
            check.append(i)

    if len(check) == 1:
        print(win)
    else:
        print(check[0])