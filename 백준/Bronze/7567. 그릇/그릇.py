import sys
input = sys.stdin.readline

plates = input().rstrip()
H = 10

for i in range(1, len(plates)):
    if plates[i] == plates[i - 1]:
        H += 5
    else:
        H += 10

print(H)