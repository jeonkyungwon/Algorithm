import sys
input = sys.stdin.readline

N, M = map(int, input().split())
note = set([input().rstrip() for _ in range(N)])

for _ in range(M):
    blog = input().rstrip().split(',')

    for b in blog:
        if b in note:
            note.discard(b)

    print(len(note))