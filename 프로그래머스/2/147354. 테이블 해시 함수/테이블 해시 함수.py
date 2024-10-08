def solution(data, col, row_begin, row_end):
    answer = 0
    data.sort(reverse = True)
    data.sort(key = lambda x: x[col - 1])
    
    for i in range(row_begin - 1, row_end):
        S = 0
        for j in range(0, len(data[i])):
            S +=  data[i][j] % (i + 1)
        answer ^= S
        
    return answer