import sys
input = sys.stdin.readline

N = int(input())
pillars = []

for _ in range(N):
    L, H = map(int, input().split())
    pillars.append((L, H))

# 좌표 기준 정렬
pillars.sort()

# 가장 높은 기둥 찾기
top_height = max(pillars, key=lambda x: x[1])[1]
top_pillars = [p for p in pillars if p[1] == top_height]
left_top = top_pillars[0][0]
right_top = top_pillars[-1][0]

# 왼쪽 → 최고높이 기둥까지
cur_l = pillars[0][0]
cur_h = pillars[0][1]
area = 0

for L, H in pillars:
    if L > left_top:
        break
    if H > cur_h:
        area += (L - cur_l) * cur_h
        cur_l = L
        cur_h = H

# 오른쪽 → 최고높이 기둥까지
cur_r = pillars[-1][0]
cur_h = pillars[-1][1]

for L, H in reversed(pillars):
    if L < right_top:
        break
    if H > cur_h:
        area += (cur_r - L) * cur_h
        cur_r = L
        cur_h = H

# 가장 높은 구간 넓이
area += (right_top - left_top + 1) * top_height
print(area)