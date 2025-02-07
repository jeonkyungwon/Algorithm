def solution(n, words):
    answer = [words[0]]
    cnt, person = 0, 1
    
    for i in range(1, len(words)):
        if words[i] in answer or words[i - 1][-1] != words[i][0] :
            return [person + 1, cnt + 1]
        else:
            answer.append(words[i])
        
        person += 1
        if person == n:
            person = 0
            cnt += 1
    
    return [0, 0]