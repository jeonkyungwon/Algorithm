def solution(s):
    answer = []
    cnt, zeroCnt = 0, 0     
    
    while 1:
        if s == "1":
            break;
            
        zeroCnt += s.count("0") 
        s = s.replace("0",'')  
        s = bin(len(s))[2:]     
        
        cnt +=1
        
    answer = [cnt, zeroCnt]    
    return answer