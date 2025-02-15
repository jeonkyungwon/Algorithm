def solution(s):
    stack = [s[0]]
    
    for i in range(1, len(s)):
        if not stack or s[i] != stack[-1]:
            stack.append(s[i])
        else:
            stack.pop()
    
    if stack:
        return 0
    
    return 1