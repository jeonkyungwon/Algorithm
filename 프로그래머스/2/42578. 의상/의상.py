def solution(clothes):
    answer = 1
    styles = {}
    
    for cloth in clothes:
        if cloth[1] not in styles:
            styles[cloth[1]] = 0
        styles[cloth[1]] += 1

    for key in styles:
        answer *= (styles[key] + 1)

    return answer - 1