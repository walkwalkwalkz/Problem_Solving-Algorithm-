dx=[0,0,-1,1]
dy=[-1,1,0,0]

def getminnode():
    minVal=150000
    x,y=-1,-1
    for i in range(n):
        for j in range(n):
            if checked[i][j]==0 and minVal>cost[i][j]:
                minVal = cost[i][j]
                x=i
                y=j
    return x,y


def dij(x,y):
    cost[x][y]=arr[x][y]

    for _ in range((n*n)-1):
        checked[x][y]=1
        for i in range(4):
            xx = x + dx[i]
            yy = y + dy[i]
            if 0<=xx<n and 0<=yy<n and checked[xx][yy]==0 and cost[xx][yy]>cost[x][y]+arr[xx][yy]:
                cost[xx][yy] = cost[x][y]+arr[xx][yy]
        
        x,y = getminnode()

tc=1
while True:
    n=int(input())
    if n==0:
        break

    arr=[list(map(int,input().split())) for _ in range(n)]

    checked=[[0]*n for _ in range(n)]
    cost=[[150000]*n for _ in range(n)]
    dij(0,0)
    print(f"Problem {tc}: {cost[n-1][n-1]}")
    tc+=1