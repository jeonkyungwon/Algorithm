N = int(input())
sum = 0
sum += N // 5
N %= 5

while sum >= 0:
  if N % 3 == 0:
    sum += N // 3
    break
  else:
    N = N + 5
    sum -= 1
  
if sum < 0:
  sum = -1




    
print(sum)