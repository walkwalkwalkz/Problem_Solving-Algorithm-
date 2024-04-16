dp=[[1]*10 for _ in range(66)]
for i in range(2,66):
    for j in range(1,10):
        dp[i][j]=dp[i-1][j]+dp[i][j-1]

for _ in range(int(input())):
    n=int(input())
    print(dp[n+1][-1])