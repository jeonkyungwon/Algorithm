from math import ceil

def solution(progresses, speeds):
    days = [ceil((100 - p) / s) for p, s in zip(progresses, speeds)]
    
    answer = [] 
    front_day = days[0] 
    count = 0  

    for day in days:
        if day <= front_day:
            count += 1 
        else:
            answer.append(count) 
            count = 1
            front_day = day

    answer.append(count)  
    return answer