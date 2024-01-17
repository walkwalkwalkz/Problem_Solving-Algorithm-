arr1=input()
arr2=input()

dp=[[0]*(len(arr2)+1) for _ in range(len(arr1)+1)]

for i in range(1,len(arr1)+1):
    for j in range(1,len(arr2)+1):
        if arr1[i-1]==arr2[j-1]:
            dp[i][j]=dp[i-1][j-1]+1
        else:
            dp[i][j]=max(dp[i-1][j],dp[i][j-1])

x=len(arr1)
y=len(arr2)
res=''
while dp[x][y]>0:
    while dp[x][y]==dp[x][y-1]:
        y-=1
    while dp[x][y]==dp[x-1][y]:
        x-=1
    res=arr1[x-1]+res
    x-=1
    y-=1
print(res)