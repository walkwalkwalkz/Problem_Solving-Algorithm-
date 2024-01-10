from collections import deque

dx=[0,0,-1,1]
dy=[-1,1,0,0]

arr=[list(map(int,input().split())) for _ in range(5)]
r,c=map(int,input().split())
move=0

for t in range(1,7):
    dq=deque([(r,c,move)])
    check=[[0]*5 for _ in range(5)]
    check[r][c]=1
    while dq:
        x,y,m=dq.popleft()
        if arr[x][y]==t:
            r,c,move=x,y,m
            break
        for i in range(4):
            xx = x + dx[i]
            yy = y + dy[i]
            if 0<=xx<5 and 0<=yy<5 and arr[xx][yy]!=-1 and check[xx][yy]==0:
                check[xx][yy]=1
                dq.append((xx,yy,m+1))
    else:
        print(-1)
        break
else:
    print(move)