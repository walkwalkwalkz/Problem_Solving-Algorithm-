import heapq

n=int(input())
arr=[list(map(float,input().split())) for _ in range(n)]
dis=[[0]*n for _ in range(n)]

for i in range(n-1):
    for j in range(i+1,n):
        tmp=(((arr[i][0]-arr[j][0])**2)+((arr[i][1]-arr[j][1])**2))**(0.5)
        dis[i][j]=tmp
        dis[j][i]=tmp

res=[10000]*n
hq=[]
heapq.heappush(hq,(0.0,0))

cnt=0
while hq:
    d,x = heapq.heappop(hq)
    
    if res[x]!=10000: continue

    res[x]=d
    cnt+=1

    if cnt==n:
        break

    for i in range(n):
        if x!=i and res[i]>dis[x][i]:
            heapq.heappush(hq,(dis[x][i],i))

print(f"{sum(res):.2f}")