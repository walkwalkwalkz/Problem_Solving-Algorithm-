n=int(input())
m=int(input())

arr=[[0]*(n+1) for _ in range(n+1)]
brr=[[0]*(n+1) for _ in range(n+1)]

for _ in range(m):
    a,b=map(int,input().split())
    arr[a][b]=1
    brr[b][a]=1

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            if arr[i][k]==1 and arr[k][j]==1:
                arr[i][j]=1
for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            if brr[i][k]==1 and brr[k][j]==1:
                brr[i][j]=1

for i in range(1,n+1):
    tmp=0
    for j in range(1,n+1):
        if arr[i][j]==0 and brr[i][j]==0:
            tmp+=1
    print(tmp-1)