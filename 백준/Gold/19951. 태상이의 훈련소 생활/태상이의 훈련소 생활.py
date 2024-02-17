n,m = map(int,input().split())
arr=list(map(int,input().split()))
tmp=[0]*(n+1)

for i in range(m):
    a,b,k=map(int,input().split())
    tmp[a-1]+=k
    tmp[b]+=-k

t=0
for i in range(n):
    t+=tmp[i]
    arr[i]+=t
print(*arr)