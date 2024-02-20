from collections import deque

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def bfs():
    cnt=0
    dq = deque([[0,0]])
    visited[0][0]=1

    while dq:
        x,y = dq.popleft()
        for i in range(4):
            xx = x + dx[i]
            yy = y + dy[i]
            if 0<=xx<n and 0<=yy<m and visited[xx][yy]==0:
                visited[xx][yy]=1
                if arr[xx][yy]==0:
                    dq.append([xx,yy])
                else:
                    arr[xx][yy]=0
                    cnt+=1
    return cnt


n,m = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]
res=[]
time = 0
while True:
    time += 1
    visited = [[0]*m for _ in range(n)]
    cnt = bfs()
    res.append(cnt)

    if cnt==0:
        break

print(time-1)
print(res[-2])
