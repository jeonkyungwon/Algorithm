def solution(n, words):
    answer = [words[0]]
    cnt, person = 0, 1
    
    for i in range(1, len(words)):
        if words[i] in answer or words[i - 1][-1] != words[i][0] :
            return [(i % n) + 1, (i // n) + 1]
        
        answer.append(words[i])
    
    return [0, 0]