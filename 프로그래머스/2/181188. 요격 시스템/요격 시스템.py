def solution(targets):
    # 목표를 끝나는 지점 기준으로 오름차순 정렬
    targets.sort(key=lambda x: x[1])
    
    answer = 0
    last_end = 0  # 마지막으로 요격된 목표의 끝나는 지점
    
    for start, end in targets:
        # 현재 목표의 시작 지점이 마지막 요격된 목표의 끝나는 지점보다 크면
        if start >= last_end:
            # 새로운 요격 필요
            answer += 1
            last_end = end  # 현재 목표의 끝나는 지점을 업데이트
            
    return answer