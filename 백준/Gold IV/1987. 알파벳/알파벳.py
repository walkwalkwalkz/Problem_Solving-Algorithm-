dx=[-1,1,0,0]
dy=[0,0,-1,1]

def dfs(x,y,L):
    global res
    if res<L:
        res=L
    apb[ord(arr[x][y])-65]=1

    for i in range(4):
        xx=x+dx[i]
        yy=y+dy[i]
        if 0<=xx<r and 0<=yy<c and apb[ord(arr[xx][yy])-65] == 0:
            dfs(xx,yy,L+1)
            apb[ord(arr[xx][yy])-65]=0

r,c=map(int,input().split())
arr=[list(input()) for _ in range(r)]
apb=[0 for _ in range(26)]
res=0
dfs(0,0,1)
print(res)