from collections import deque

dx=[-1,1,0,0]
dy=[0,0,-1,1]

n=int(input())
arr=[list(input()) for _ in range(n)]

area=0
check=1
areanums=[]
visited=[[0]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if arr[i][j]=='#' and visited[i][j]==0:
            dq=deque([(i,j)])
            visited[i][j]=check
            tmp=1
            while dq:
                x,y=dq.popleft()

                for i in range(4):
                    xx = x + dx[i]
                    yy = y + dy[i]
                    if 0<=xx<n and 0<=yy<n and arr[xx][yy]=='#' and visited[xx][yy]==0:
                        tmp+=1
                        visited[xx][yy]=check
                        dq.append((xx,yy))
            
            check+=1
        
            if area<tmp:
                area=tmp
                areanums=[check-1]
            elif area==tmp:
                areanums.append(check-1)
per=4000000

for areanum in areanums:
    tmp=0
    for i in range(n):
        for j in range(n):
            if visited[i][j]==areanum:
                cnt=0
                for k in range(4):
                    ii = i + dx[k]
                    jj = j + dy[k]
                    if 0<=ii<n and 0<=jj<n and visited[ii][jj]==areanum:
                        cnt+=1
                tmp+=4-cnt
    if per>tmp:
        per=tmp
print(area,per)