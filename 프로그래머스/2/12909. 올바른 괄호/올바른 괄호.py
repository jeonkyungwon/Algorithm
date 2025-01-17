def solution(s):
    B = []
    
    for i in s:
        if i == '(':
            B.append(i)
        else:
            if not B:
                return False
            B.pop()
            
    return True if not B else False