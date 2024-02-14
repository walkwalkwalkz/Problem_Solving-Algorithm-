from collections import deque

dx=[0,0,-1,1]
dy=[-1,1,0,0]

def bfs(sx,sy,lx,ly,maps):
    visited=[[0]*len(maps[0]) for _ in range(len(maps))]
    visited[sx][sy]=1
    dq = deque([(sx,sy)])
    while dq:
        x,y = dq.popleft()
        
        if x==lx and y==ly:
            break
        
        for i in range(4):
            xx = x + dx[i]
            yy = y + dy[i]
            if 0<=xx<len(maps) and 0<=yy<len(maps[0]) and visited[xx][yy]==0 and maps[xx][yy]!='X':
                visited[xx][yy]=visited[x][y]+1
                dq.append((xx,yy))
    
    if visited[lx][ly]==0:
        return False
    
    return visited[lx][ly]-1

def solution(maps):
    answer=0
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j]=='S':
                sx = i
                sy = j
            elif maps[i][j]=='L':
                lx = i
                ly = j
            elif maps[i][j]=='E':
                ex = i
                ey = j
                
    tmp = bfs(sx,sy,lx,ly,maps)
    if tmp:
        answer+=tmp
    else:
        return -1
    
    tmp = bfs(lx,ly,ex,ey,maps)
    if tmp:
        answer+=tmp
    else:
        return -1
    
    return answer