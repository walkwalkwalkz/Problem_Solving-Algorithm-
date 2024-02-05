n=int(input())
arr=list(map(int,input().split()))
dp=[1]*n
res=[[i] for i in arr]
maxVal=1
maxIdx=0

for i in range(n-2,-1,-1):
    tmp=0
    restmp=[]
    for j in range(i+1,n):
        if arr[i]<arr[j] and dp[j]>tmp:
            tmp=dp[j]
            restmp=res[j]
    dp[i]+=tmp
    res[i]+=restmp

    if dp[i]>maxVal:
        maxVal=dp[i]
        maxIdx=i

print(maxVal)
print(*res[maxIdx])