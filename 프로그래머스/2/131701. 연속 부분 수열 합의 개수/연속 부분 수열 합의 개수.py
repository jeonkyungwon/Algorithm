def solution(elements):
    result = set()
    a = len(elements)
    
    extended_elements = elements * 2

    for i in range(a):
        sum_subseq = 0
        for j in range(i, i + a):
            sum_subseq += extended_elements[j]
            result.add(sum_subseq)
                
    return len(result)