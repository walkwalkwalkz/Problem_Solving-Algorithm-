n,t = map(int,input().split())
dp=[0]*(t+1)

res=0
for _ in range(n):
    d,m=map(int,input().split())
    res+=m
    for i in range(t,d-1,-1):
        if dp[i]<dp[i-d]+m:
            dp[i]=dp[i-d]+m

print(res-dp[-1])