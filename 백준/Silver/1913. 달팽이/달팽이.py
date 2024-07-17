import sys
input = sys.stdin.readline

#정중앙부터 상우하좌 순서로 1, 1, 2, 2, 3, 3..... 이렇게 진행이 되는걸 확인함
#그러면 dx, dy를 두고 상우하좌 순서로 돌리면 될듯?
#변수 하나 만들어서 1부터 두번씩 돌리고 1씩 증가 시키도록 코드 짜봐야겠다

N = int(input())
num = int(input())
snail = [[0] * N for _ in range(N)]
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]
x, y = N // 2, N // 2 # 시작점은 중앙
current_num = 1
direction = 0 # 상우하좌 순서로 0, 1, 2, 3
step_count = 1 # 같은 방향으로 몇 번 이동할지
steps = 0 # 현재 방향으로 몇 번 이동했는지
change_step = 0 # 방향을 몇 번 바꿨는지

while current_num <= N * N:
    snail[x][y] = current_num
    if current_num == num:
        result_x, result_y = x, y
    current_num += 1
    x += dx[direction]
    y += dy[direction]
    steps += 1

    if steps == step_count:
        direction = (direction + 1) % 4 
        steps = 0
        change_step += 1
        if change_step == 2: # 두 번 방향을 바꿀 때마다 step_count 증가
            step_count += 1
            change_step = 0

for i in range(N):
    print(*snail[i])

print(result_x + 1, result_y + 1)