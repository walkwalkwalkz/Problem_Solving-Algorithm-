n=int(input())

dp=[0]*(50001)
dp[0]=1
dp[1]=1
dp[2] = 1

for i in range(3,n+1):
    dp[i]=(dp[i-1]+dp[i-3])%1000000009
print(dp[n]%1000000009)