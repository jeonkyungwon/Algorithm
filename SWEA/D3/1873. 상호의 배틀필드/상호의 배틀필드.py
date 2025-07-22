T = int(input())
for i in range(1, T + 1):
    H, W = map(int, input().split())
    field = [list(input().rstrip()) for _ in range(H)]
    N = int(input())
    cmd = input().rstrip()
    found = False

    for j in range(H):
        for k in range(W):
            if field[j][k] == '<' or field[j][k] == '^' or field[j][k] == '>' or field[j][k] == 'v':
                x, y = j, k
                found = True
                break
        if found:
            break

    for c in cmd:
        if c == 'U':
            field[x][y] = '^'
            if x - 1 >= 0 and field[x - 1][y] == '.':
                field[x][y] = '.'
                x -= 1
                field[x][y] = '^'
        elif c == 'D':
            field[x][y] = 'v'
            if x + 1 < H and field[x + 1][y] == '.':
                field[x][y] = '.'
                x += 1
                field[x][y] = 'v'
        elif c == 'L':
            field[x][y] = '<'
            if y - 1 >= 0 and field[x][y - 1] == '.':
                field[x][y] = '.'
                y -= 1
                field[x][y] = '<'
        elif c == 'R':
            field[x][y] = '>'
            if y + 1 < W and field[x][y + 1] == '.':
                field[x][y] = '.'
                y += 1
                field[x][y] = '>'
        elif c == 'S':
            if field[x][y] == '^':
                for l in range(x - 1, -1, -1):
                    if field[l][y] == '#':
                        break
                    elif field[l][y] == '*':
                        field[l][y] = '.'
                        break
            elif field[x][y] == 'v':
                for l in range(x + 1, H):
                    if field[l][y] == '#':
                        break
                    elif field[l][y] == '*':
                        field[l][y] = '.'
                        break
            elif field[x][y] == '<':
                for l in range(y - 1, -1, -1):
                    if field[x][l] == '#':
                        break
                    elif field[x][l] == '*':
                        field[x][l] = '.'
                        break
            elif field[x][y] == '>':
                for l in range(y + 1, W):
                    if field[x][l] == '#':
                        break
                    elif field[x][l] == '*':
                        field[x][l] = '.'
                        break

    print('#{}'.format(i), end=' ')
    for f in field:
        print(''.join(f))