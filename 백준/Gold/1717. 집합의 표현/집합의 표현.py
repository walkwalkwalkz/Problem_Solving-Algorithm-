import sys
sys.setrecursionlimit(10**5)

def find(a):
    if a!=arr[a]:
        arr[a] = find(arr[a])
        return arr[a]
    return a

def union(a,b):
    a=find(a)
    b=find(b)

    if(a<b):
        arr[b]=a
    else:
        arr[a]=b

n,m = map(int,sys.stdin.readline().split())
arr=[0]*(n+1)
for i in range(1,n+1):
    arr[i]=i

for _ in range(m):
    s,a,b=map(int,sys.stdin.readline().split())

    if s==0:
        union(a,b)
    else:
        if(find(a)==find(b)):
            print('YES')
        else:
            print('NO')