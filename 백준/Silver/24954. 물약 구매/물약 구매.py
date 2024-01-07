from itertools import permutations

n=int(input())
arr=list(map(int,input().split()))
case=permutations(range(0,n))

info=[]
for _ in range(n):
    p=int(input())
    tmp=[]
    for _ in range(p):
        a,b=map(int,input().split())
        tmp.append((a-1,b))
    info.append(tmp)

res=10000
for c in case:
    copyarr=arr[:]
    tmp=0
    for i in c:
        tmp+=copyarr[i]
        if res<=tmp:
            break
        copyarr[i]=0
        for a,b in info[i]:
            copyarr[a]=max(1,copyarr[a]-b)
    if res>tmp:
        res=tmp
print(res)