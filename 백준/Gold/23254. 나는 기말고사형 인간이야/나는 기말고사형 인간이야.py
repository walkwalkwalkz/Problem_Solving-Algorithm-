import heapq

n,m = map(int,input().split())

a=list(map(int,input().split()))
b=list(map(int,input().split()))
h=[]

n*=24
for i in range(m):
    heapq.heappush(h,(-b[i],a[i],i+1))

res=sum(a)
while h:
    if n==0:
        break

    x,y,idx=heapq.heappop(h)
    x=-x
    t=(100-y)%x
    tmp=(100-y)//x
    if n>=tmp:
        res+=tmp*x
        n-=tmp
        if t!=0:
            heapq.heappush(h,(-t,100-t,idx))
    else:
        res+=x*n
        n=0
print(res)