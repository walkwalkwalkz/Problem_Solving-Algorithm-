from collections import deque

# def printarr():
#     for a in arr:
#         print(a)

dx=[-1,1,0,0]
dy=[0,0,-1,1]

n,m,t=map(int,input().split())
arr=[]

for _ in range(n):
    arr.append(deque(list(map(int,input().split()))))

# printarr()
for _ in range(t):
    x,d,k = map(int,input().split())
    for xx in range(x,n+1,x):
        if d==0:
            arr[xx-1].rotate(k)
        else:
            arr[xx-1].rotate(-k)
    # print("회전후")
    # printarr()
    flag1=0
    for i in range(n):
        for j in range(m):
            if arr[i][j]!=0:
                tmp=arr[i][j]
                dq=deque([(i,j)])
                flag2=0
                while dq:
                    x,y = dq.popleft()

                    for k in range(4):
                        xx = x + dx[k]
                        yy = (y + dy[k])%m
                        if 0<=xx<n and arr[xx][yy]==tmp:
                            flag2=1
                            flag1=1
                            arr[xx][yy]=0
                            dq.append((xx,yy))
                if flag2==1:
                    arr[i][j]=0
                    # print(i,j,"에서 부터 지워짐")
                    # printarr()
    
    if flag1==0:
        cnt=0
        sumval=0
        for i in range(n):
            for j in range(m):
                if arr[i][j]!=0:
                    cnt+=1
                    sumval+=arr[i][j]
        if cnt!=0:
            avg=sumval/cnt
            for i in range(n):
                for j in range(m):
                    if arr[i][j]!=0:
                        if arr[i][j]>avg:
                            arr[i][j]-=1
                        elif arr[i][j]<avg:
                            arr[i][j]+=1
    #     print("안지워짐")
    #     printarr()
    
    # print(arr)

res=0
for a in arr:
    res+=sum(a)
print(res)