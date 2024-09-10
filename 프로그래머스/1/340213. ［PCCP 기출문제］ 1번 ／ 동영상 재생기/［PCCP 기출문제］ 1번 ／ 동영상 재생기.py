def solution(video_len, pos, op_start, op_end, commands):
    answer = ''
    video_len = int(video_len[0:2]) * 60 + int(video_len[3:5])
    pos = int(pos[0:2]) * 60 + int(pos[3:5])
    op_start = int(op_start[0:2]) * 60 + int(op_start[3:5])
    op_end = int(op_end[0:2]) * 60 + int(op_end[3:5])
    
    for cmd in commands:
        if op_start <= pos <= op_end:
            pos = op_end
            
        if cmd == "prev":
            if pos - 10 < 0:
                pos = 0
            else:
                pos -= 10
        else:
            if pos + 10 > video_len:
                pos = video_len
            else:
                pos += 10
                
    if op_start <= pos <= op_end:
            pos = op_end
    
    if pos < 0:
        pos = 0
    if pos > video_len:
        pos = video_len
    
    if pos // 60 < 10:
        answer += "0" + str(pos // 60)
    else:
        answer = str(pos // 60)
    
    answer += ":"
    
    if pos % 60 < 10:
        answer += "0" + str(pos % 60)
    else:
        answer += str(pos % 60)
        
    return answer