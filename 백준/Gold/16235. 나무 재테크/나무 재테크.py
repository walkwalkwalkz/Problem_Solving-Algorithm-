from collections import deque

dx=[0,0,-1,1,1,1,-1,-1]
dy=[-1,1,0,0,1,-1,1,-1]

def ss():
    for i in range(n):
        for j in range(n):
            t=[]
            dead=0
            for k in range(len(arr[i][j])):
                if arr[i][j][k]<=land[i][j]:
                    land[i][j]-=arr[i][j][k]
                    arr[i][j][k]+=1
                else:
                    leng=len(arr[i][j])
                    for _ in range(leng-k):
                        dead+=arr[i][j].pop()//2
                    break
            land[i][j]+=dead

def fw():
    for i in range(n):
        for j in range(n):
            for a in arr[i][j]:
                if a%5==0:
                    for k in range(8):
                        x = i + dx[k]
                        y = j + dy[k]
                        if 0<=x<n and 0<=y<n:
                            arr[x][y].appendleft(1)
            land[i][j]+=A[i][j]


n,m,k=map(int,input().split())

arr=[[[] for _ in range(n)] for _ in range(n)] #나무있는 땅
land=[[5]*n for _ in range(n)] #양분있는 땅
A=[list(map(int,input().split())) for _ in range(n)] #추가되는 양분

for _ in range(m):
    x,y,z=map(int,input().split())
    arr[x-1][y-1].append(z)

for i in range(n):
    for j in range(n):
        arr[i][j]=deque(sorted(arr[i][j]))

for _ in range(k):
    # 봄 # 여름
    ss()
    # 가을 # 겨울
    fw()
res=0
for i in range(n):
    for j in range(n):
        res+=len(arr[i][j])
print(res)