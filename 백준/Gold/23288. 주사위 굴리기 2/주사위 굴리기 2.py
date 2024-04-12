from collections import deque

dx=[0,1,0,-1]
dy=[1,0,-1,0]

def getscore(x,y):
    visited=[[0]*m for _ in range(n)]
    tmp = arr[x][y]
    dq=deque([(x,y)])
    visited[x][y]=1
    score=1

    while dq:
        a,b=dq.popleft()

        for i in range(4):
            xx = a + dx[i]
            yy = b + dy[i]
            if 0<=xx<n and 0<=yy<m and visited[xx][yy]==0 and arr[xx][yy]==tmp:
                score+=1
                visited[xx][yy]=1
                dq.append((xx,yy))

    return score

n,m,k = map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]

dqc=deque([4,1,3,6])
dqr=deque([2,1,5,6])

x,y=0,0
d=0
res=0
for _ in range(k):
    xx = x + dx[d]
    yy = y + dy[d]
    if 0<=xx<n and 0<=yy<m:
        x=xx
        y=yy
    else:
        d = (d+2)%4
        x = x + dx[d]
        y = y + dy[d]
    # print(x,y)

    if d==0:
        dqc.rotate(1)
        dqr[1]=dqc[1]
        dqr[3]=dqc[3]
    elif d==1:
        dqr.rotate(1)
        dqc[1]=dqr[1]
        dqc[3]=dqr[3]
    elif d==2:
        dqc.rotate(-1)
        dqr[1] = dqc[1]
        dqr[3] = dqc[3]
    else:
        dqr.rotate(-1)
        dqc[1] = dqr[1]
        dqc[3] = dqr[3]

    res+=getscore(x,y)*arr[x][y]
    # print(x,y)
    # print(getscore(x,y)*arr[x][y])

    if dqr[3]>arr[x][y]:
        d = (d+1)%4
    if dqr[3]<arr[x][y]:
        d-=1
        if d==-1:
            d=3
print(res)