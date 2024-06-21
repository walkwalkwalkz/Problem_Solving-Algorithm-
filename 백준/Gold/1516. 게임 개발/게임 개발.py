import heapq

n=int(input())
time=[0]*(n+1)
hq=[]
arr=[[] for _ in range(n+1)]
indegree=[0]*(n+1)

for i in range(1,n+1):
    tmp = list(map(int,input().split()))
    time[i]=tmp[0]
    if tmp[1]==-1:
        heapq.heappush(hq,(time[i],i))
    else:
        for j in tmp[1:-1]:
            arr[j].append(i)
    indegree[i]=len(tmp)-2

while hq:
    t,x = heapq.heappop(hq)

    for xx in arr[x]:
        indegree[xx]-=1
        if indegree[xx]==0:
            time[xx]+=t
            heapq.heappush(hq,(time[xx],xx))

for i in range(1,n+1):
    print(time[i])