def dfs(list,idx):
    global min
    if len(list)==n//2:
        start=0
        link=0
        for i in range(n):
            for j in range(n):
                if i==j:
                    continue
                if (i+1) in list and (j+1) in list:
                    start+=arr[i][j]
                if (i+1) not in list and (j+1) not in list:
                    link+=arr[i][j]
        if min>abs(start-link):
            min=abs(start-link)
    else:
        for i in range(idx,n):
            dfs(list+[i+1],i+1)

n=int(input())
arr=[list(map(int,input().split())) for _ in range(n)]
tmp=[1]
min=99
dfs(tmp,1)
print(min)