from collections import deque

dx=[0,0,-1,1,1,1,-1,-1]
dy=[-1,1,0,0,1,-1,1,-1]

def dfs(x,y,ll):
    if check[x][y][ll-1]!=0:
        return check[x][y][ll-1]
    if ll==l:
        return 1
    
    tmp=0
    for i in range(8):
        xx = x + dx[i]
        yy = y + dy[i]
        if 0<=xx<h and 0<=yy<w and word[ll]==arr[xx][yy]:
            tmp+=dfs(xx,yy,ll+1)
    check[x][y][ll-1]+=tmp
    return tmp


h,w,l=map(int,input().split())
arr=[list(input()) for _ in range(h)]
word=input()
check=[[[0]*l for _ in range(w)] for _ in range(h)]

res=0
for i in range(h):
    for j in range(w):
        if arr[i][j]==word[0]:
            res+=dfs(i,j,1)  
print(res) 