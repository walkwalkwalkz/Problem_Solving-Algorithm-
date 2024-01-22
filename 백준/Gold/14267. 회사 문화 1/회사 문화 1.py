from collections import deque
import sys

n,m=map(int,sys.stdin.readline().split())
arr=list(map(int,sys.stdin.readline().split()))
comp=[[] for _ in range(n+1)]

for i in range(1,n):
    comp[arr[i]].append(i+1)

res=[0]*(n+1)
tmp=[0]*(n+1)
for _ in range(m):
    i,w = map(int,sys.stdin.readline().split())
    tmp[i]+=w

dq=deque([(1,0)])
while dq:
    x,p=dq.popleft()
    res[x]=p

    for xx in comp[x]:
        dq.append((xx,p+tmp[xx]))

for i in range(1,n+1):
    print(res[i],end=' ')