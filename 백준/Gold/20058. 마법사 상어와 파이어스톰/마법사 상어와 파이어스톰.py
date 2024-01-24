from collections import deque
import copy

dx=[0,1,0,-1]
dy=[1,0,-1,0]

def storm(x,y,l):

    while(l>1):
        dq=deque()
        idx=0
        a=x
        b=y
        for _ in range((l*4)-4):
            dq.append(arr[a][b])
            if((x>a+dx[idx])or(a+dx[idx]>=x+l)or(y>b+dy[idx])or(b+dy[idx]>=y+l)):
                idx+=1
            a=a+dx[idx]
            b=b+dy[idx]
        
        dq.rotate(l-1)

        a=x
        b=y
        idx=0
        for _ in range((l*4)-4):
            arr[a][b]=dq.popleft()
            if((x>a+dx[idx])or(a+dx[idx]>=x+l)or(y>b+dy[idx])or(b+dy[idx]>=y+l)):
                idx+=1
            a=a+dx[idx]
            b=b+dy[idx]

        x+=1
        y+=1
        l-=2


n,q = map(int,input().split())
n=2**n
arr=[list(map(int,input().split())) for _ in range(n)]
level=list(map(int,input().split()))

for qq in range(q):
    l=2**(level[qq])
    for i in range(0,n,l):
        for j in range(0,n,l):
            storm(i,j,l)
    
    next=[[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if arr[i][j]==0:
                next[i][j]=arr[i][j]
                continue
            tmp=0
            for k in range(4):
                xx=i+dx[k]
                yy=j+dy[k]
                if 0<=xx<n and 0<=yy<n and arr[xx][yy]!=0:
                    tmp+=1
            if tmp>=3:
                next[i][j]=arr[i][j]
            else:
                next[i][j]=arr[i][j]-1

    arr=copy.deepcopy(next)

visited=[[0]*n for _ in range(n)]
res=0
maxVal=0
for i in range(n):
    for j in range(n):
        if arr[i][j]!=0 and visited[i][j]==0:
            res+=arr[i][j]
            tmp=1
            dq=deque([(i,j)])
            visited[i][j]=1

            while dq:
                x,y=dq.popleft()

                for k in range(4):
                    xx = x + dx[k]
                    yy = y + dy[k]
                    if 0<=xx<n and 0<=yy<n and arr[xx][yy]!=0 and visited[xx][yy]==0:
                        visited[xx][yy]=1
                        dq.append((xx,yy))
                        tmp+=1
                        res+=arr[xx][yy]
            if maxVal<tmp:
                maxVal=tmp

print(res)
print(maxVal)