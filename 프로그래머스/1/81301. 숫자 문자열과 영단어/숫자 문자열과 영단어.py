def solution(s):
    answer = 0
    word = ''
    number = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    
    for ch in s:
        if 'a' <= ch <= 'z':
            word += ch
            if word in number :
                answer = answer * 10 + number.index(word)
                word = ''
        else:
            answer = answer * 10 + int(ch)
        
    return answer