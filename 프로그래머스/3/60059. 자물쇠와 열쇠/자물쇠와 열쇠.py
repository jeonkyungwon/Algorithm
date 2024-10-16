def rotate_90(matrix):
    n = len(matrix)
    return [[matrix[n - 1 - j][i] for j in range(n)] for i in range(n)]

def extend_lock(lock, key_size):
    lock_size = len(lock)
    new_size = lock_size + (key_size - 1) * 2
    extended_lock = [[0] * new_size for _ in range(new_size)]
    
    # 기존 자물쇠를 확장된 자물쇠의 중앙에 배치
    for i in range(lock_size):
        for j in range(lock_size):
            extended_lock[key_size - 1 + i][key_size - 1 + j] = lock[i][j]
    
    return extended_lock

def can_unlock(extended_lock, key, start_x, start_y, lock_size, key_size):
    # 확장된 자물쇠에 열쇠를 더해봄
    for i in range(key_size):
        for j in range(key_size):
            extended_lock[start_x + i][start_y + j] += key[i][j]
    
    # 자물쇠의 원래 영역이 모두 1인지 확인
    for i in range(lock_size):
        for j in range(lock_size):
            if extended_lock[key_size - 1 + i][key_size - 1 + j] != 1:
                return False
    return True

def solution(key, lock):
    lock_size = len(lock)
    key_size = len(key)
    extended_lock = extend_lock(lock, key_size)
    
    for _ in range(4):  # 4번 회전
        key = rotate_90(key)
        
        # 확장된 자물쇠에 대해 열쇠를 모든 위치에 맞춰봄
        for x in range(len(extended_lock) - key_size + 1):
            for y in range(len(extended_lock) - key_size + 1):
                # 자물쇠를 복사해 임시로 열쇠를 맞춰봄
                temp_lock = [row[:] for row in extended_lock]
                
                if can_unlock(temp_lock, key, x, y, lock_size, key_size):
                    return True

    return False