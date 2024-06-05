def find(a):
    if(parents[a]==a):
        return a
    
    parents[a]=find(parents[a])
    return parents[a]

def union(a,b,flag):
    a = find(a)
    b = find(b)
    if(a==b):
        return True
    if flag==0:
        parents[a]=b
    return False

n,m = map(int,input().split())
parents=[i for i in range(n+1)]

knowTrue=list(map(int,input().split()))
knowTrue=knowTrue[1:]
arr=[]
for _ in range(m):
    tmp=list(map(int,input().split()))
    for i in range(1,tmp[0]):
        union(tmp[i],tmp[i+1],0)
    arr.append(tmp[1:])

res=0
for a in arr:
    flag=0
    for aa in a:
        for kt in knowTrue:
            if union(aa,kt,1):
                flag=1
                break
        if flag==1: break
    if flag==0:
        res+=1

print(res)