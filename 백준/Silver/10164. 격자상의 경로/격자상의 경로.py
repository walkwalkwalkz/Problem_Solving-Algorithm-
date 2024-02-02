n,m,k=map(int,input().split())
arr=[[0]*(m+1) for _ in range(n+1)]

if k==0:
    arr[1][1]=1
    for i in range(1,n+1):
        for j in range(1,m+1):
            arr[i][j]+=arr[i-1][j]+arr[i][j-1]
    print(arr[n][m])
else:
    x = ((k-1)//m) + 1
    y = ((k-1)%m) + 1

    arr[x][y]=1
    for i in range(x,n+1):
        for j in range(y,m+1):
            arr[i][j]+=arr[i-1][j]+arr[i][j-1]

    arr[1][1]=1
    arr[x][y]=0
    for  i in range(1,x+1):
        for  j in range(1,y+1):
            arr[i][j]+=arr[i-1][j]+arr[i][j-1]
    
    print(arr[x][y]*arr[n][m])