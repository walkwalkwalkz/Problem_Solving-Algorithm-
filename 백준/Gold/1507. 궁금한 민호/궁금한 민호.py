n=int(input())
arr=[list(map(int,input().split())) for _ in range(n)]
check = [[1]*n for _ in range(n)]

for k in range(n):
    for i in range(n):
        for j in range(n):
            if i==j or i==k or j==k:
                continue
            if arr[i][j] == arr[i][k]+arr[k][j]:
                check[i][j]=0
            elif arr[i][j] > arr[i][k]+arr[k][j]:
                print(-1)
                exit(0)

res=0
for i in range(n):
    for j in range(n):
        if check[i][j]==1:
            res+=arr[i][j]
print(res//2)