from itertools import permutations
import copy
from collections import deque

def spinarr(x,y,d):
    while d>1:
        dq=deque()
        for i in range(d):
            dq.append(arr1[x][y+i])
        for i in range(1,d):
            dq.append(arr1[x+i][y+d-1])
        for i in range(1,d):
            dq.append(arr1[x+d-1][y+d-1-i])
        for i in range(1,d-1):
            dq.append(arr1[x+d-1-i][y])

        dq.rotate(1)

        for i in range(d):
            arr1[x][y + i]=dq.popleft()
        for i in range(1,d):
            arr1[x + i][y + d - 1]=dq.popleft()
        for i in range(1,d):
            arr1[x + d - 1][y + d - 1 - i]=dq.popleft()
        for i in range(1,d-1):
            arr1[x + d - 1 - i][y]=dq.popleft()

        # for a in arr1:
        #     print(a)
        # print()

        d-=2
        x+=1
        y+=1

n,m,k = map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
spins=[]
for _ in range(k):
    r,c,s=map(int,input().split())
    spins.append((r,c,s))
minval=5001
for p in permutations(spins):
    arr1 = copy.deepcopy(arr)
    for rr,cc,ss in p:
        x=rr-ss-1
        y=cc-ss-1
        d=(ss*2)+1
        spinarr(x,y,d)
    for a in arr1:
        sumval = sum(a)
        if sumval<minval:
            minval = sumval
print(minval)