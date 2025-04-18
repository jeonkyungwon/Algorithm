import sys
input = sys.stdin.readline

N, X = map(int, input().split())
visit_count = list(map(int, input().split()))
current_sum = sum(visit_count[:X])
max_visit = current_sum
period_count = 1

for i in range(X, N):
    current_sum = current_sum - visit_count[i - X] + visit_count[i]

    if current_sum > max_visit:
        max_visit = current_sum
        period_count = 1
    elif current_sum == max_visit:
        period_count += 1

if max_visit == 0:
    print("SAD")
else:
    print(max_visit, period_count, sep='\n')