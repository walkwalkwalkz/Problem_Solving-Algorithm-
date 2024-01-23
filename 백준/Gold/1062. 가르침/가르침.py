from itertools import combinations

n,k=map(int,input().split())
s=set(['a','n','t','i','c'])
tmpset=set()
arr=[]

for _ in range(n):
        w=input()
        arr.append(w[4:-4])
        for ar in arr:
            for a in ar:
                if a not in s:
                    tmpset.add(a)

if k<5:
    print(0)
else:
    k-=5

    if len(tmpset)<=k:
        print(n)
        exit(0)

    res=0
    for a in combinations(tmpset,k):
        for i in range(len(a)):
            s.add(a[i])
        
        tmp=0
        for ar in arr:
            for r in ar:
                if r not in s:
                    break
            else:
                tmp+=1
        if res<tmp:
            res=tmp

        for i in range(len(a)):
            s.remove(a[i])
    print(res)