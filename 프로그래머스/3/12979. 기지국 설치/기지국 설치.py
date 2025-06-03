import math

def solution(n, stations, w):
    answer = 0
    coverage = 2 * w + 1
    prev = 1 

    for station in stations:
        left = station - w 
        right = station + w 

        if left > prev:
            gap = left - prev
            answer += math.ceil(gap / coverage)

        prev = right + 1  

    if prev <= n:
        gap = n - prev + 1
        answer += math.ceil(gap / coverage)

    return answer