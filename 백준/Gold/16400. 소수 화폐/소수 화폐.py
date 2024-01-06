n=int(input())

arr=[0]*(n+1)
dp=[0]*(n+1)
dp[0]=1
for i in range(2,n+1):
    if arr[i]==0:
        for j in range(i,n+1):
            dp[j]=(dp[j]+dp[j-i])%123456789
        for j in range(i+i,n+1,i):
            arr[j]=1
print(dp[-1])