def solution(N, stages):
    answer = [0] * (N + 1)
    rate = []
    result = []
    person = len(stages)

    for i in stages:
        if i <= N:
            answer[i] += 1

    for i in range(1, N + 1):
        if person == 0:
            rate.append([0, i])
        else:
            rate.append([answer[i] / person, i])
        person -= answer[i]

    rate.sort(key=lambda x: (-x[0], x[1]))

    for i in range(N):
        result.append(rate[i][1])

    return result