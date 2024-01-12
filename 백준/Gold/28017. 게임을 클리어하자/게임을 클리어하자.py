n,m = map(int,input().split())
dp=[[5000000]*(m) for _ in range(n+1)]

for i in range(m):
    dp[0][i]=0

for i in range(1,n+1):
    arr=list(map(int,input().split()))
    for j in range(m):
        for k in range(m):
            if j!=k and dp[i][j]>arr[j]+dp[i-1][k]:
                dp[i][j]=arr[j]+dp[i-1][k]
print(min(dp[-1]))