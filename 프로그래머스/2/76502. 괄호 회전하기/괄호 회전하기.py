from collections import deque

def check_s(s):
    a = [s[0]]
    for i in range(1, len(s)):
        if s[i] == '(' or s[i] == '{' or s[i] == '[':
            a.append(s[i])
        else:
            if a:
                if s[i] == ')' and a[-1] == "(":
                    a.pop()
                if s[i] == '}' and a[-1] == "{":
                    a.pop()
                if s[i] == ']' and a[-1] == "[":
                    a.pop()
                    
    if a:
        return 0
    
    return 1

def solution(s):
    answer, cnt = 0, 0
    dq = deque(s)
    
    for i in range(len(dq)):
        cnt = check_s(dq)
        
        if cnt == 1:
            answer += 1
        
        dq.append(dq.popleft())
    
    return answer