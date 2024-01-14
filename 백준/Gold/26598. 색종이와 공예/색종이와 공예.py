from collections import deque

dx=[0,0,-1,1]
dy=[-1,1,0,0]

n,m=map(int,input().split())
arr=[list(input()) for _ in range(n)]
checked=[[0]*m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if checked[i][j]==0:
            checked[i][j]=1
            dq=deque([(i,j)])

            xtmp=0
            ytmp=0
            while dq:
                x,y=dq.popleft()

                if x>xtmp:
                    xtmp=x
                if y>ytmp:
                    ytmp=y
                if x<i or y<j:
                    print('BaboBabo')
                    exit(0)

                for k in range(4):
                    xx = x + dx[k]
                    yy = y + dy[k]
                    if 0<=xx<n and 0<=yy<m and arr[xx][yy]==arr[x][y] and checked[xx][yy]==0:
                        checked[xx][yy]=1
                        dq.append((xx,yy))
            
            for k in range(i,xtmp+1):
                for y in range(j,ytmp+1):
                    if checked[k][y]==0:
                        print('BaboBabo')
                        exit(0)
print('dd')