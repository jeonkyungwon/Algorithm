from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = deque([0] * bridge_length)
    wait_truck = deque(truck_weights)
    bridge_weight = 0
    
    while wait_truck or bridge_weight > 0:
        answer += 1
        bridge_weight -= bridge.popleft()
        
        if wait_truck and bridge_weight + wait_truck[0] <= weight:
            bridge.append(wait_truck[0])
            bridge_weight += wait_truck[0]
            wait_truck.popleft()
        else:
            bridge.append(0)
    
    return answer