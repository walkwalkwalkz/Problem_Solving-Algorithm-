n=int(input())
m=int(input())
arr=[[0]*(n+1) for _ in range(n+1)]

for _ in range(m):
    a,b,c = map(int,input().split())
    if arr[a][b]==0:
        arr[a][b]=c
    elif arr[a][b]>c:
        arr[a][b]=c

for i in range(1,n+1):
    for j in range(1,n+1):
        for k in range(1,n+1):
            if j!=k and arr[k][i]!=0 and arr[i][j]!=0:
                if arr[k][j]>arr[k][i]+arr[i][j] or arr[k][j]==0:
                    arr[k][j]=arr[k][i]+arr[i][j]
            
for i in range(1,n+1):
    for j in range(1,n+1):
        print(arr[i][j],end=' ')
    print()