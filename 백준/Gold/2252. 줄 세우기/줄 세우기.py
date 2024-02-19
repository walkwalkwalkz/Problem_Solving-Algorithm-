from collections import deque

n,m = map(int,input().split())
ws=[0]*(n+1)
arr=[[] for _ in range(n+1)]

for _ in range(m):
    a,b = map(int,input().split())
    arr[a].append(b)
    ws[b]+=1

dq = deque([])
for i in range(1,n+1):
    if ws[i]==0:
        dq.append(i)

while dq:
    x = dq.popleft()
    print(x,end=' ')

    for xx in arr[x]:
        if(ws[xx]>0):
            ws[xx]-=1
            if ws[xx]==0:
                dq.append(xx)