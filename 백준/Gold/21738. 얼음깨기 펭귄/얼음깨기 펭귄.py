from collections import deque

n,s,p = map(int,input().split())
arr = [[] for _ in range(n+1)]
ggd = set([ i for i in range(1,s+1)])
visited = [0]*(n+1)

for _ in range(n-1):
    a,b = map(int,input().split())
    arr[a].append(b)
    arr[b].append(a)


dq=deque([p])
visited[p]=1
flag=0
res=0
while dq:
    x = dq.popleft()

    if x in ggd:
        flag+=1
        res+=visited[x]-1
        if flag==2:
            break
        continue

    for ar in arr[x]:
        if visited[ar]==0:
            visited[ar]=visited[x]+1
            dq.append(ar)
print(n-1-res)