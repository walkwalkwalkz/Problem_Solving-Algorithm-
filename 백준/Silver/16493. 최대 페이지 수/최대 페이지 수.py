n,m = map(int,input().split())
dp=[0]*(n+1)
for i in range(m):
    d,p = map(int,input().split())
    for j in range(n,d-1,-1):
        dp[j]=max(dp[j],dp[j-d]+p)
print(dp[-1])