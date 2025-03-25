import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    equ = input().split()
    result = float(equ[0])

    for i in range(1,len(equ)):
        if equ[i] == '@':
            result *= 3
        elif equ[i] == '%':
            result += 5
        elif equ[i] == '#':
            result -= 7

    print("%0.2f" % result)