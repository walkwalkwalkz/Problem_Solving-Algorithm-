from collections import deque

dx=[0,0,-1,1]
dy=[-1,1,0,0]

def solution(maps):
    answer = []
    
    visited = [[0]*len(maps[0]) for _ in range(len(maps))]
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j]!='X' and visited[i][j]==0:
                tmp=0
                visited[i][j]=1
                dq = deque([(i,j)])
                while dq:
                    x,y=dq.popleft()
                    tmp+=int(maps[x][y])
                    
                    for k in range(4):
                        xx = x + dx[k]
                        yy = y + dy[k]
                        if 0<=xx<len(maps) and 0<=yy<len(maps[0]) and maps[xx][yy]!='X' and visited[xx][yy]==0:
                            visited[xx][yy]=1
                            dq.append((xx,yy))
                answer.append(tmp)
        if len(answer)==0:
            answer.append(-1)
        else:
            answer.sort()
    
    return answer