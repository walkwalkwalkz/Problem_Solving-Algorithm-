n,c=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]            

while True:
    s=0
    for i in range(n):
        h=0
        w=0
        for j in range(n):
            if arr[i][j]==c:
                w+=1
            if arr[j][i]==c:
                h+=1
        if n>w>n//2:
            for j in range(n):
                arr[i][j]=c
            s+=1
        if n>h>n//2:
            for j in range(n):
                arr[j][i]=c
            s+=1
    if s==0:
        break

bp=0
for i in range(n):
    for j in range(n):
        if arr[i][j]!=c:
            print(0)
            bp=1
            break
    if bp==1:
        break
else:
    print(1)