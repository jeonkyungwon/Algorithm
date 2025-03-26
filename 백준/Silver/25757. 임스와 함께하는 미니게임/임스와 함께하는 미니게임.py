import sys
input = sys.stdin.readline

games = {"Y": 2, "F": 3, "O": 4}
N, game = input().split()
player = set()

for _ in range(int(N)):
    name = input().rstrip()
    player.add(name)

cnt = len(player) // (games[game] - 1)

print(cnt)