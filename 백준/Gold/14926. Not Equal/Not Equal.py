n=int(input())
nc2=(n*(n-1))//2
check=[[0]*(n+1) for _ in range(n+1)]
check[-1][1]=1
check[1][-1]=1
cv=0
for i in range(nc2):
    for j in range(1,n+1):
        if cv!=j and check[cv][j]==0:
            check[cv][j]=1
            check[j][cv]=1
            print('a'+str(j),end=' ')
            cv=j
            break
print('a1')