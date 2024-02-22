import heapq

n=int(input())
m=int(input())
arr=[[0]*(n+1) for _ in range(n+1)]

for _ in range(m):
    a,b,c=map(int,input().split())
    arr[a][b]=c
    arr[b][a]=c

dis=[False]*(n+1)
res=0
hq=[]
heapq.heappush(hq,(0,1))

while hq:
    d,x = heapq.heappop(hq)
    if(dis[x]==False):
        dis[x]=True
        res+=d
        for i in range(1,n+1):
            if(arr[x][i]!=0 and dis[i]==False):
                heapq.heappush(hq,(arr[x][i],i))
print(res)