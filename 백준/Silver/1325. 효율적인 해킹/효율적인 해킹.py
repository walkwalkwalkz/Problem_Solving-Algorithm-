import sys
from collections import deque

def bfs(a):
    tmp = 1
    dq = deque([a])
    checked=[0]*(n+1)
    checked[a]=1

    while dq:
        x = dq.popleft()

        for i in arr[x]:
            if checked[i]==0:
                checked[i]=1
                tmp+=1
                dq.append(i)
    return tmp


n,m = map(int,input().split())
arr=[[] for _ in range(n+1)]
res=[0]*(n+1)

for _ in range(m):
    a,b=map(int,sys.stdin.readline().split())
    arr[b].append(a)

for i in range(1,n+1):
    res[i] = bfs(i)


maxVal=max(res)
for i in range(1,n+1):
    if res[i]==maxVal:
        print(i,end=' ')