dp = [[0]*2001 for _ in range(2001)]

for i in range(2001):
    dp[i][0]=0
    dp[0][i]=1

for i in range(1,2001):
    for j in range(1,2001):
        if j>i:
            dp[i][j] = dp[i][j-1]
        else:
            dp[i][j] = (dp[i][j-1] + dp[i-j][j-1])%100999

for _ in range(int(input())):
    n=int(input())
    print(dp[n][n])