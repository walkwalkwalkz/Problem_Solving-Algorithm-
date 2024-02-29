from collections import deque

def dfs(t):

    for x in arr[t]:
        if(visited[x]==-1):
            visited[x]=visited[t]+1
            dfs(x)

n=int(input())
arr=[[] for _ in range(n+1)]
indegree = [0]*(n+1)

for _ in range(n):
    a,b=map(int,input().split())
    arr[a].append(b)
    arr[b].append(a)
    indegree[a]+=1
    indegree[b]+=1

dq = deque([]);
visited=[0]*(n+1)

for i in range(1,n+1):
    if(indegree[i]==1):
        dq.append(i)
        visited[i]=-1

temp=[]
while dq:
    x=dq.popleft()

    for xx in arr[x]:
        if(visited[xx]==0):
            indegree[xx]-=1
            if(indegree[xx]==1):
                dq.append(xx)
                visited[xx]=-1
            else:
                temp.append(xx)

for t in temp:
    if(visited[t]==0):
        dfs(t)

print(*visited[1:])