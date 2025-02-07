def solution(k, tangerine):
    answer = 0
    box = {}

    for size in tangerine:
        box[size] = box.get(size, 0) + 1  

    sorted_box = sorted(box.values(), reverse=True)

    total = 0
    for count in sorted_box:
        total += count
        answer += 1 
        if total >= k:
            return answer