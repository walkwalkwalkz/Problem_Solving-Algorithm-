from collections import deque

dx=[0,0,0,-1,1]
dy=[0,1,-1,0,0]

n,m,x,y,k = map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]

dqr=deque([0,0,0,0])
dqc=deque([0,0,0,0])
#동쪽 -> dqc.append(dqc.popleft()) dqr[1]=dqc[1],dqr[3]=dqc[3]
#서쪽 -> dqc.appendleft(dqc.pop()) dqr[1]=dqc[1],dqr[3]=dqc[3]
#북쪽 -> dqr.appendleft(dqr.pop()) dqc[1]=dqr[1],dqc[3]=dqr[3]
#남쪽 -> dqr.append(dqr.popleft()) dqc[1]=dqr[1],dqc[3]=dqr[3]

order=map(int,input().split())
for o in order:
    xx = x + dx[o]
    yy = y + dy[o]
    if 0<=xx<n and 0<=yy<m:
        if o==1:
            dqc.append(dqc.popleft())
            if arr[xx][yy]==0:
                arr[xx][yy]=dqc[1]
            else:
                dqc[1]=arr[xx][yy]
                arr[xx][yy]=0
            dqr[1]=dqc[1]
            dqr[3]=dqc[3]
        elif o==2:
            dqc.appendleft(dqc.pop())
            if arr[xx][yy]==0:
                arr[xx][yy]=dqc[1]
            else:
                dqc[1]=arr[xx][yy]
                arr[xx][yy] = 0
            dqr[1]=dqc[1]
            dqr[3]=dqc[3]
        elif o==3:
            dqr.appendleft(dqr.pop())
            if arr[xx][yy] == 0:
                arr[xx][yy] = dqr[1]
            else:
                dqr[1] = arr[xx][yy]
                arr[xx][yy] = 0
            dqc[1]=dqr[1]
            dqc[3]=dqr[3]
        else:
            dqr.append(dqr.popleft())
            if arr[xx][yy] == 0:
                arr[xx][yy] = dqr[1]
            else:
                dqr[1] = arr[xx][yy]
                arr[xx][yy] = 0
            dqc[1] = dqr[1]
            dqc[3] = dqr[3]
        x=xx
        y=yy
        # print("order :",o)
        # print(x,y)
        # print(dqr)
        # print(dqc)
        # for a in arr:
        #     print(a)
        print(dqr[3])
        # print()