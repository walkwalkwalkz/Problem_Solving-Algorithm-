from itertools import combinations
from collections import deque

def bfs(c):
    dq=deque([c[0]])
    s=set(c[1:])
    sum=0
    cnt=0
    while dq:
        x=dq.popleft()

        sum+=pop[x-1]
        cnt+=1

        for a in arr[x]:
            if a in s:
                dq.append(a)
                s.remove(a)
    
    return sum,cnt

n=int(input())
pop=list(map(int,input().split()))
area=[i for i in range(1,n+1)]
sa=set(area)
arr=[[]]

for _ in range(n):
    tmp=list(map(int,input().split()))
    arr.append(tmp[1:])

res=1001
for i in range(1,n//2+1):
    for c in combinations(area,i):
        s1,c1=bfs(c)
        s2,c2=bfs(list(sa-set(c)))

        if c1+c2==n:
            res=min(res,abs(s1-s2))

if res==1001:
    print(-1)
else:
    print(res)