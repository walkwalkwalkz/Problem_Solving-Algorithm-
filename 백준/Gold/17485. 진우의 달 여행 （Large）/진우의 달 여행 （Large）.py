dy=[-1,0,1]

n,m = map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]

dp=[[[100000,100000,100000] for _ in range(m)] for _ in range(n)]
for i in range(m):
    for j in range(3):
        dp[0][i][j]=arr[0][i]

for i in range(n-1):
    for j in range(m):
        for k in range(3):
            yy = j + dy[k]
            if 0<=yy<m:
                for l in range(3):
                    if l!=k and dp[i+1][yy][l]>dp[i][j][k]+arr[i+1][yy]:
                        dp[i+1][yy][l]=dp[i][j][k]+arr[i+1][yy]

res=100000
for i in range(m):
    for j in range(3):
        if res>dp[-1][i][j]:
            res=dp[-1][i][j]
print(res)