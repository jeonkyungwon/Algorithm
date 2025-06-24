import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
balloons = [(i + 1, nums[i]) for i in range(N)]
position = 0

idx, move = balloons.pop(0)
result = [idx]

if balloons:
    if move > 0:
        position = (position + move - 1) % len(balloons)
    else:
        position = (position + move) % len(balloons)

while balloons:
    idx, move = balloons.pop(position)
    result.append(idx)

    if not balloons:
        break

    if move > 0:
        position = (position + move - 1) % len(balloons)
    else:
        position = (position + move) % len(balloons)

print(*result)