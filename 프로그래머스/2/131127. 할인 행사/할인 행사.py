from collections import Counter

def check_register(discount, product):
    counter = Counter(discount)

    for key in product:
        if counter[key] != product[key]:
            return 0 
        
    return 1

def solution(want, number, discount):
    answer = 0
    product = {}
    
    for i in range(len(want)):
        product[want[i]] = number[i]
        
    for i in range(len(discount) - 9):
        answer += check_register(discount[i:i + 10], product)
    
    return answer