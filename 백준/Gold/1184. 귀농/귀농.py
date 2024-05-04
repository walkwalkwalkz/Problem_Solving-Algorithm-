def subtotal(sx,sy,ex,ey):
    return prefixsum[ex][ey]-prefixsum[sx-1][ey]-prefixsum[ex][sy-1]+prefixsum[sx-1][sy-1]

n=int(input())
arr=[list(map(int,input().split())) for _ in range(n)]

prefixsum=[[0]*(n+1) for _ in range(n+1)]
for i in range(1,n+1):
    for j in range(1,n+1):
        prefixsum[i][j]=prefixsum[i-1][j]+prefixsum[i][j-1]-prefixsum[i-1][j-1]+arr[i-1][j-1]

res=0
for i in range(1,n):
    for j in range(1,n):
        dic={}
        for x in range(1,i+1):
            for y in range(1,j+1):
                tmp = subtotal(x,y,i,j)
                if tmp in dic:
                    dic[tmp]+=1
                else:
                    dic[tmp]=1
        for x in range(i+1,n+1):
            for y in range(j+1,n+1):
                tmp = subtotal(i+1,j+1,x,y)
                if tmp in dic:
                    res+=dic[tmp]
        
        dic={}
        for x in range(1,i+1):
            for y in range(j+1,n+1):
                tmp = subtotal(x,j+1,i,y)
                if tmp in dic:
                    dic[tmp]+=1
                else:
                    dic[tmp]=1
        for x in range(i+1,n+1):
            for y in range(1,j+1):
                tmp = subtotal(i+1,y,x,j)
                if tmp in dic:
                    res+=dic[tmp]

print(res)