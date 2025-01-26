def solution(n):
    answer, i = 0, 1
    
    while i <= n:
        result = 0
        
        for j in range(i, n + 1):
            result += j
            
            if result == n:
                answer += 1
                break
            elif result > n:
                break
                
        i += 1
            
    return answer