def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def lcm(a, b):
    return (a * b) // gcd(a, b)

def solution(arr):
    lcm_result = arr[0] 
    
    for num in arr[1:]: 
        lcm_result = lcm(lcm_result, num)
        
    return lcm_result    
    