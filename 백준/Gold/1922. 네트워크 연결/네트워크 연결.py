def find(a):
    if parents[a]==a:
        return a
    
    parents[a]=find(parents[a])
    return parents[a]

def union(a,b):
    a=find(a)
    b=find(b)

    if(a<b):
        parents[b]=a
    else:
        parents[a]=b

n=int(input())
m=int(input())
arr=[]

parents=[0] + [ i for i in range(1,n+1)]
res=0
for _ in range(m):
    a,b,c = map(int,input().split())
    arr.append((c,a,b))

arr.sort()
for c,a,b in arr:
    if(find(a)!=find(b)):
        union(a,b)
        res+=c
print(res)