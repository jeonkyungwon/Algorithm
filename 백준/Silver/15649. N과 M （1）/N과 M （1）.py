from itertools import permutations
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
num = permutations(range(1, N + 1), M)
for i in num:
    print(" ".join(map(str, i)))