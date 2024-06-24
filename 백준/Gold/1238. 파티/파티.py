import heapq

n,m,x = map(int,input().split())
arr1=[[] for _ in range(n+1)]
arr2=[[] for _ in range(n+1)]

for _ in range(m):
    a,b,t = map(int,input().split())
    arr1[a].append((b,t))
    arr2[b].append((a,t))

dist1=[100001]*(n+1)
dist1[x]=0
hq=[]
heapq.heappush(hq,(0,x))

while hq:
    t,b = heapq.heappop(hq)

    if dist1[b] < t:
        continue

    for b1,t1 in arr1[b]:
        if dist1[b1]>t+t1:
            dist1[b1]=t+t1
            heapq.heappush(hq,(dist1[b1],b1))

dist2=[100001]*(n+1)
dist2[x]=0
hq=[]
heapq.heappush(hq,(0,x))

while hq:
    t,b = heapq.heappop(hq)

    if dist2[b] < t:
        continue

    for b1,t1 in arr2[b]:
        if dist2[b1]>t+t1:
            dist2[b1]=t+t1
            heapq.heappush(hq,(dist2[b1],b1))

res=0
for i in range(1,n+1):
    if res<dist1[i]+dist2[i]:
        res=dist1[i]+dist2[i]
print(res)