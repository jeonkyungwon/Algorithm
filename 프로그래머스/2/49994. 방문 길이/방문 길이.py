def solution(dirs):
    visited = set()
    x, y = 0, 0
    answer = 0

    move = {'U': (0, 1), 'D': (0, -1),
            'R': (1, 0), 'L': (-1, 0)}

    for d in dirs:
        dx, dy = move[d]
        nx, ny = x + dx, y + dy

        if not (-5 <= nx <= 5 and -5 <= ny <= 5):
            continue

        path = ((x, y), (nx, ny)) if (x, y) < (nx, ny) else ((nx, ny), (x, y))

        if path not in visited:
            visited.add(path)
            answer += 1

        x, y = nx, ny

    return answer