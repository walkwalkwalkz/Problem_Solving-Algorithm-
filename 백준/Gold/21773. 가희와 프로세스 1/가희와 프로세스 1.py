import heapq

t,n = map(int,input().split())

hq=[]
for _ in range(n):
    a,b,c=map(int,input().split())
    heapq.heappush(hq,[-c,a,b])

idhq=[]
for _ in range(t):
    if not idhq:
        p = hq[0][0]
        while hq and p==hq[0][0]:
            c,a,b=heapq.heappop(hq)
            heapq.heappush(idhq,[a,b,c])

    a,b,c = heapq.heappop(idhq)
    print(a)
    b-=1
    if b>0:
        heapq.heappush(hq,[c+1,a,b])