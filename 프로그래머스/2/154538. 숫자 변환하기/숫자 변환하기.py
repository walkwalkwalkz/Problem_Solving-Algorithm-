from collections import deque

def solution(x, y, n):
    answer = -1
    visited = [0]*(y+1)
    
    dq = deque([(x,0)])
    visited[x]=1
    
    while dq:
        num,cnt = dq.popleft()
        if num==y:
            answer=cnt
            break
        tmp = num+n
        if tmp<=y and visited[tmp]==0:
            visited[tmp]=1
            dq.append((tmp,cnt+1))
        
        tmp = num*2
        if tmp<=y and visited[tmp]==0:
            visited[tmp]=1
            dq.append((tmp,cnt+1))
        
        tmp = num*3
        if tmp<=y and visited[tmp]==0:
            visited[tmp]=1
            dq.append((tmp,cnt+1))
        
    return answer