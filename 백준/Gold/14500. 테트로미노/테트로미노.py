n,m=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]

res=0
for i in range(n):
    for j in range(m-3):
        tmp=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i][j+3]
        if res<tmp:
            res=tmp
for i in range(n-1):
    for j in range(m-1):
        tmp=arr[i][j]+arr[i][j+1]+arr[i+1][j]+arr[i+1][j+1]
        if res<tmp:
            res=tmp
for i in range(n-2):
    for j in range(m-1):
        tmp=arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+2][j+1]
        if res<tmp:
            res=tmp
for i in range(n-1):
    for j in range(m-2):
        tmp=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j]
        if res<tmp:
            res=tmp
for i in range(n-2):
    for j in range(m-1):
        tmp=arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+2][j+1]
        if res<tmp:
            res=tmp
for i in range(1,n):
    for j in range(m-2):
        tmp=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i-1][j+2]
        if res<tmp:
            res=tmp
for i in range(2,n):
    for j in range(m-1):
        tmp=arr[i][j]+arr[i][j+1]+arr[i-1][j+1]+arr[i-2][j+1]
        if res<tmp:
            res=tmp
for i in range(n-1):
    for j in range(m-2):
        tmp=arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+1][j+2]
        if res<tmp:
            res=tmp
for i in range(n-2):
    for j in range(m-1):
        tmp=arr[i][j]+arr[i][j+1]+arr[i+1][j]+arr[i+2][j]
        if res<tmp:
            res=tmp
for i in range(n-1):
    for j in range(m-2):
        tmp=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+2]
        if res<tmp:
            res=tmp
for i in range(n-2):
    for j in range(m-1):
        tmp=arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+2][j+1]
        if res<tmp:
            res=tmp
for i in range(1,n):
    for j in range(m-2):
        tmp=arr[i][j]+arr[i][j+1]+arr[i-1][j+1]+arr[i-1][j+2]
        if res<tmp:
            res=tmp
for i in range(2,n):
    for j in range(m-1):
        tmp=arr[i][j]+arr[i-1][j]+arr[i-1][j+1]+arr[i-2][j+1]
        if res<tmp:
            res=tmp
for i in range(n-1):
    for j in range(m-2):
        tmp=arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+1][j+2]
        if res<tmp:
            res=tmp
for i in range(n-1):
    for j in range(m-2):
        tmp=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]
        if res<tmp:
            res=tmp
for i in range(1,n-1):
    for j in range(m-1):
        tmp=arr[i][j]+arr[i][j+1]+arr[i-1][j+1]+arr[i+1][j+1]
        if res<tmp:
            res=tmp
for i in range(1,n):
    for j in range(m-2):
        tmp=arr[i][j]+arr[i][j+1]+arr[i-1][j+1]+arr[i][j+2]
        if res<tmp:
            res=tmp
for i in range(n-2):
    for j in range(m-1):
        tmp=arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+2][j]
        if res<tmp:
            res=tmp
for i in range(n-3):
    for j in range(m):
        tmp=arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+3][j]
        if res<tmp:
            res=tmp
print(res)