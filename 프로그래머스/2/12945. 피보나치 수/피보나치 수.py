def solution(n):
    F = [0, 1]
    
    for i in range(n):
        F.append(F[i] + F[i + 1])
    
    return F[n] % 1234567