dx=[0,0,1,-1]
dy=[1,-1,0,0]

def dfs(l,x,y,p):
    global res
    if p==0:
        return
    if l==n:
        res+=p
        return

    for i in range(4):
        xx = x + dx[i]
        yy = y + dy[i]
        if arr[xx][yy]==0:
            arr[xx][yy]=1
            dfs(l+1,xx,yy,p*per[i])
            arr[xx][yy]=0
        
arr=[[0]*29 for _ in range(29)]
per=list(map(int,input().split()))
n=per[0]
per=per[1:]
for i in range(4):
    per[i]/=100
res=0.0
arr[14][14]=1
dfs(0,14,14,1)
print(res)