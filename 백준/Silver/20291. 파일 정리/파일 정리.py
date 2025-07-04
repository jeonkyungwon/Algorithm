import sys
input = sys.stdin.readline

N = int(input())
files = {}

for _ in range(N):
    extension = input().rstrip().split('.')
    if extension[1] not in files:
        files[extension[1]] = 0
    files[extension[1]] += 1

for key, value in sorted(files.items()):
    print(key, value)