from bisect import bisect_left

n=int(input())
arr=list(map(int,input().split()))
dp=[arr[0]]

for i in range(1,n):
    if(dp[-1]<arr[i]):
        dp.append(arr[i])
    else:
        dp[bisect_left(dp,arr[i])]=arr[i]

print(len(dp))