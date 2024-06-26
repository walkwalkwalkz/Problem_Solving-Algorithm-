def find(x):
    if x==parents[x]:
        return x
    
    parents[x]=find(parents[x])
    return parents[x]

def union(a,b):
    a=find(a)
    b=find(b)

    if a<b:
        parents[b]=a
        num[a]+=num[b]
        print(num[a])
    elif b<a:
        parents[a]=b
        num[b]+=num[a]
        print(num[b])
    else:
        print(num[a])
    

for _ in range(int(input())):
    f=int(input())
    parents={}
    num={}

    for _ in range(f):
        a,b = input().split()
        if a not in parents:
            parents[a]=a
            num[a]=1
        if b not in parents:
            parents[b]=b
            num[b]=1
        union(a,b)