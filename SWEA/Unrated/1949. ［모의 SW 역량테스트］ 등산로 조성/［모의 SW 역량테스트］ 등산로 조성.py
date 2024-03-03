dx=[-1,1,0,0]
dy=[0,0,-1,1]

def dfs(x,y,k,f):
    global maxval
    if visited[x][y]>maxval:
        maxval = visited[x][y]

        # for i in range(n):
        #     for j in range(n):
        #         print(visited[i][j],end=' ')
        #     print()
        # print()
        # for i in range(n):
        #     for j in range(n):
        #         print(arr[i][j],end=' ')
        #     print()
        # print()
        #
        # print()

    for i in range(4):
        xx = x + dx[i]
        yy = y + dy[i]
        if 0<=xx<n and 0<=yy<n and visited[xx][yy]==0:
            if f==0 and arr[xx][yy]>=arr[x][y] and k>=arr[xx][yy]-arr[x][y]+1:
                tmp = arr[xx][yy]-arr[x][y]+1
                arr[xx][yy]-=tmp
                visited[xx][yy]=visited[x][y]+1
                dfs(xx,yy,k-tmp,1)
                arr[xx][yy] += tmp
                visited[xx][yy] = 0
            elif arr[xx][yy]<arr[x][y]:
                visited[xx][yy] = visited[x][y] + 1
                dfs(xx, yy, k , f)
                visited[xx][yy] = 0

for tc in range(1,int(input())+1):
    n,k = map(int,input().split())
    arr=[[0]*n for _ in range(n)]
    maxval=0
    for i in range(n):
        tmp=list(map(int,input().split()))
        for j in range(n):
            arr[i][j]=tmp[j]
            if tmp[j]>maxval:
                maxval=tmp[j]

    tmp=[]
    for i in range(n):
        for j in range(n):
            if(maxval==arr[i][j]):
                tmp.append((i,j))

    maxval=0
    for x,y in tmp:
        visited = [[0] * n for _ in range(n)]
        visited[x][y] = 1
        dfs(x,y,k,0)
        visited[x][y] = 0

    print(f"#{tc} {maxval}")