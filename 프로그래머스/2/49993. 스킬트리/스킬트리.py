def solution(skill, skill_trees):
    answer = 0
    
    for tree in skill_trees:
        i, check = 0, 0
        
        for j in range(len(tree)):
            if i < len(skill) - 1:
                if tree[j] == skill[i]:
                    i += 1
                elif tree[j] in skill[i + 1:]:
                    check += 1
                    break
        
        if check == 0:
            answer += 1
            
    return answer