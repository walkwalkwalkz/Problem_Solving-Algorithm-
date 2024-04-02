import heapq

for _ in range(int(input())):
    n,d,c = map(int,input().split())

    arr=[[] for _ in range(n+1)]
    for _ in range(d):
        a,b,s = map(int,input().split())
        arr[b].append((a,s))

    # arr=[[0]*(n+1) for _ in range(n+1)]
    # for _ in range(d):
    #     a,b,s = map(int,input().split())
    #     arr[b][a]=s
    
    dis=[0]*(n+1)
    hq=[]
    cnt=0
    maxVal=0
    heapq.heappush(hq,(1,c))
    while hq:
        t,x = heapq.heappop(hq)

        if dis[x]==0:
            dis[x]=t
            cnt+=1
            maxVal=t
        else:
            continue
        
        for d,sec in arr[x]:
            if dis[d]==0:
                heapq.heappush(hq,(t+sec,d))

        # for i in range(1,n+1):
        #     if arr[x][i]!=0 and dis[i]==0:
        #         heapq.heappush(hq,(t+arr[x][i],i))
    
    # cnt=0
    # maxVal=0
    # for d in dis:
    #     if d!=0:
    #         cnt+=1
    #         if d>maxVal:
    #             maxVal=d
    print(cnt,maxVal-1)