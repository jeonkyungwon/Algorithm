def solution(n, times):
    s, e = min(times), max(times) * n
    while s <= e:
        mid  = (s + e) // 2
        answer = 0
        
        for time in times:
            answer += mid // time
        
        if answer >= n:
            e = mid - 1
            result = mid
        elif answer < n:
            s = mid + 1
    
    return result
