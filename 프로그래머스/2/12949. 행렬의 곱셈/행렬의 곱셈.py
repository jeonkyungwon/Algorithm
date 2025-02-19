def solution(arr1, arr2):
    row_len = len(arr1)  
    col_len = len(arr2[0]) 
    common_len = len(arr2)

    result = [[0] * col_len for _ in range(row_len)]

    for i in range(row_len): 
        for j in range(col_len): 
            for k in range(common_len):  
                result[i][j] += arr1[i][k] * arr2[k][j]
    
    return result
