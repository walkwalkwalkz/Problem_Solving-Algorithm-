from collections import deque

atts=[(9,3,1),(9,1,3),(3,1,9),(3,9,1),(1,3,9),(1,9,3)]
checked=[[[0 for _ in range(61)] for _ in range(61)] for _ in range(61)]

n=int(input())
scv=list(map(int,input().split()))
for _ in range(3-n):
    scv.append(0)

dq=deque([tuple(scv)])
while dq:
    x,y,z=dq.popleft()

    if x==0 and y==0 and z==0:
        print(checked[0][0][0])

    for i in range(6):
        xx = max(x - atts[i][0],0)
        yy = max(y - atts[i][1],0)
        zz = max(z - atts[i][2],0)
        if checked[xx][yy][zz]==0:
            checked[xx][yy][zz]=checked[x][y][z]+1
            dq.append((xx,yy,zz))