from itertools import permutations

def solution(k, dungeons):
    max_count = 0

    for order in permutations(dungeons, len(dungeons)):
        current_k = k
        count = 0

        for need, cost in order:
            if current_k >= need:
                current_k -= cost
                count += 1
            else:
                break

        max_count = max(max_count, count)

    return max_count
