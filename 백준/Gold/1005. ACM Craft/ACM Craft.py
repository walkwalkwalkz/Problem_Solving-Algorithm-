from collections import deque

def bfs():
    w=int(input())
    dq=deque()

    for i in range(1,n+1):
        if indegree[i]==0:
            dq.append(i)
            if w==i:
                print(arr[i])
                return 
            dp[i]=arr[i]
    
    while dq:
        x = dq.popleft()

        for xx in order[x]:
            indegree[xx]-=1
            if dp[xx]<dp[x]+arr[xx]:
                dp[xx]=dp[x]+arr[xx]

            if indegree[xx]==0:
                if xx==w:
                    print(dp[w])
                    return
                dq.append(xx)


for _ in range(int(input())):
    n,k = map(int,input().split())
    arr = [0] + list(map(int,input().split()))
    order = [[] for _ in range(n+1)]
    indegree = [0]*(n+1)
    dp = [0]*(n+1)

    for _ in range(k):
        x,y = map(int,input().split())
        order[x].append(y)
        indegree[y]+=1

    bfs()