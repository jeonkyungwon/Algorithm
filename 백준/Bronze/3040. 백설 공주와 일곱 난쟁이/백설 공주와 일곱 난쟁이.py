import sys
input = sys.stdin.readline

dwarf = []
for _ in range(9):
    dwarf.append(int(input()))

total = sum(dwarf)

for i in range(8):
    for j in range(i + 1, 9):
        if total - (dwarf[i] + dwarf[j]) == 100:
            f1, f2 = i, j
            break

for i in range(9):
    if i != f1 and i != f2:
        print(dwarf[i])