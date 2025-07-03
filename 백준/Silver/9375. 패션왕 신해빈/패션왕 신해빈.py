import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    n = int(input())
    styles = {}
    for _ in range(n):
        cloth_name, cloth_type = input().split()

        if cloth_type not in styles:
            styles[cloth_type] = 0
        styles[cloth_type] += 1

    answer = 1
    for key, value in styles.items():
        answer *= (value + 1)

    print(answer - 1)