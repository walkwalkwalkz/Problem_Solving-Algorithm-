from collections import deque
import sys

for t in range(1,int(sys.stdin.readline())+1):
    n=int(sys.stdin.readline())
    k=int(sys.stdin.readline())

    arr=[[] for _ in range(n)]
    checked=[0]*(n)
    for _ in range(k):
        a,b = map(int,sys.stdin.readline().split())
        arr[a].append(b)
        arr[b].append(a)
    tmp=1
    for i in range(n):
        if checked[i]==0:
            checked[i]=tmp
            dq=deque([i])
            while dq:
                x=dq.popleft()
                for a in arr[x]:
                    if checked[a]==0:
                        checked[a]=tmp
                        dq.append(a)
            tmp+=1

    m=int(sys.stdin.readline())
    print(f"Scenario {t}:")
    for _ in range(m):
        u,v=map(int,sys.stdin.readline().split())
        if checked[u]==checked[v]:
            print(1)
        else:
            print(0)
    print()