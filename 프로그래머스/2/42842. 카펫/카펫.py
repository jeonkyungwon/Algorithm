def solution(brown, yellow):
    total = brown + yellow
    
    for y in range(2, total // 2):
        if total % y == 0:
            x = total // y 
            if (x - 2) * (y - 2) == yellow: 
                return [x, y] 
