from collections import deque

def solution(bridge_length, weight, truck_weights):
    # 시간, 다리에 올라가 있는 트럭, 대기중인 트럭, 다리에 올라와 있는 트럭의 무게를 각각 선언해준다.
    answer = 0
    bridge = deque([0] * bridge_length)
    wait_truck = deque(truck_weights)
    bridge_weight = 0

    # 대기중인 트럭이 없거나 다리에 올라와 있는 트럭이 없다면 반복문을 종료한다.
    while wait_truck or bridge_weight > 0:
        # 시간의 흐름, 한 칸씩 앞으로 이동
        answer += 1
        bridge_weight -= bridge.popleft()

        # 대기중인 트럭이 있고 다리에 올라와 있는 트럭의 무게에 다음 트럭이 올라와도 버틸 수 있다면
        if wait_truck and bridge_weight + wait_truck[0] <= weight:
            # 대기 중인 트럭을 하나 올려준다.
            bridge.append(wait_truck[0])
            bridge_weight += wait_truck[0]
            wait_truck.popleft()
        # 무게를 버틸 수 없다면 그냥 한 칸씩 이동한다.
        else:
            # 0을 넣어주면서 한 칸씩 이동시키기
            bridge.append(0)
    
    return answer

# 다리를 건너는 트럭을 확인하기 위해 0은 트럭이 없는 상태, 0이 아닌 수는 트럭의 무게로 설정
# 앞에서부터 하나씩 제거하며 시간이 지남에 따라 앞으로 한 칸씩 이동
# 대기 중인 트럭이 없거나 다리위에 트럭이 남아있지 않으면 종료
