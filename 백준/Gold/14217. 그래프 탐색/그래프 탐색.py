from collections import deque

n,m = map(int,input().split())
arr=[[2]*(n+1) for _ in range(n+1)]

for _ in range(m):
    a,b = map(int,input().split())
    arr[a][b]=1
    arr[b][a]=1

q=int(input())
for _ in range(q):
    a,i,j = map(int,input().split())
    arr[i][j]=a
    arr[j][i]=a

    dq=deque([1])
    visited=[-1]*(n+1)
    visited[1]=0
    while dq:
        x=dq.popleft()

        for xx in range(1,n+1):
            if visited[xx]==-1 and arr[x][xx]==1:
                visited[xx]=visited[x]+1
                dq.append(xx)
    print(*visited[1:])