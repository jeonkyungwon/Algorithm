def solution(numbers):
    str_numbers = list(map(str, numbers))
    str_numbers.sort(key=lambda x: x*3, reverse=True)
    answer = ''.join(str_numbers)
    
    return '0' if answer[0] == '0' else answer

# 한 자리 문자열과 두 자리 이상의 문자열을 비교할 땐
# x*3을 이용하여 숫자를 늘려 비교 기준을 맞춰서 비교한다.
