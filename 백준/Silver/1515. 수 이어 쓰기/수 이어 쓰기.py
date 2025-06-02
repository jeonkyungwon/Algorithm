import sys
input = sys.stdin.readline

nums = input().rstrip()
N = 0

while len(nums):
    N += 1 
    num = str(N)
    while len(num) and len(nums):
        if num[0] == nums[0]:
            nums = nums[1:]
        num = num[1:]

print(N)