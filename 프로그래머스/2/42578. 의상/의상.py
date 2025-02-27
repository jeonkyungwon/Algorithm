from collections import defaultdict

def solution(clothes):
    answer = 1
    clothes_dict = defaultdict(int)

    for name, category in clothes:
        clothes_dict[category] += 1

    for count in clothes_dict.values():
        answer *= (count + 1)
    
    return answer - 1  