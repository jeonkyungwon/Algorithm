from collections import deque

def solution(queue1, queue2):
    q1 = deque(queue1)
    q2 = deque(queue2)
    
    # 두 큐의 합을 미리 계산
    sum1 = sum(q1)
    sum2 = sum(q2)
    total = sum1 + sum2
    
    # 총합이 홀수면 두 큐를 같게 만들 수 없음
    if total % 2 != 0:
        return -1
    
    # 목표로 하는 각 큐의 합
    target = total // 2
    
    cnt = 0
    limit = len(q1) + len(q2) * 2
    
    # 투포인터처럼 두 큐를 비교하면서 진행
    while sum1 != target and cnt <= limit:
        if sum1 > target:
            # q1의 합이 크면 q1에서 하나를 빼서 q2에 넣음
            value = q1.popleft()
            q2.append(value)
            sum1 -= value
        else:
            # q2의 합이 크면 q2에서 하나를 빼서 q1에 넣음
            value = q2.popleft()
            q1.append(value)
            sum2 -= value
            sum1 += value
        cnt += 1
    
    # 결과 확인
    if sum1 == target:
        return cnt
    else:
        return -1