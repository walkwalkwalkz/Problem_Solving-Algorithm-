def rot1(x,y,r,val):
    if r+x>n-1-tmp:
        rot2(n-1-tmp,y,(r+x)-(n-1-tmp),val)
    else:
        res[r+x][y]=val
def rot3(x,y,r,val):
    if x-r<tmp:
        rot4(tmp,y,tmp-(x-r),val)
    else:
        res[x-r][y]=val
def rot2(x,y,r,val):
    if r+y>m-1-tmp:
        rot3(x,m-1-tmp,r+y-(m-1-tmp),val)
    else:
        res[x][r+y]=val
def rot4(x,y,r,val):
    if y-r<tmp:
        rot1(x,tmp,tmp-(y-r),val)
    else:
        res[x][y-r]=val

n,m,r=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
res=[[0]*m for _ in range(n)]

tmp=0
while (n+1)//2>tmp and (m+1)//2>tmp:
    rr=r%((n+m)*2-(tmp*8)-4)

    for i in range(tmp,n-tmp):
        rot1(i,tmp,r,arr[i][tmp])
        rot3(i,m-1-tmp,r,arr[i][m-1-tmp])
    for i in range(tmp+1,m-1-tmp):
        rot2(n-1-tmp,i,r,arr[n-1-tmp][i])
        rot4(tmp,i,r,arr[tmp][i])
    tmp+=1

for i in range(n):
    for j in range(m):
        print(res[i][j],end=' ')
    print()