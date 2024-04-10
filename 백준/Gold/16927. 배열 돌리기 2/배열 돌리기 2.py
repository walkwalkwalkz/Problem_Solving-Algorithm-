from collections import deque

n,m,r = map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]

x=0
y=0
while min(n,m)>1:
    dq=deque()

    for i in range(m):
        dq.append(arr[x][y+i])
    for i in range(1,n):
        dq.append(arr[x+i][y+m-1])
    for i in range(1,m):
        dq.append(arr[x+n-1][y+m-1-i])
    for i in range(1,n-1):
        dq.append(arr[x+n-1-i][y])

    dq.rotate(-r)

    for i in range(m):
        arr[x][y+i]=dq.popleft()
    for i in range(1,n):
        arr[x + i][y + m - 1]=dq.popleft()
    for i in range(1,m):
        arr[x + n - 1][y + m - 1 - i]=dq.popleft()
    for i in range(1,n-1):
        arr[x + n - 1 - i][y]=dq.popleft()

    n-=2
    m-=2
    x+=1
    y+=1


for a in arr:
    print(*a)