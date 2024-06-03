from collections import deque

n,m = map(int,input().split())
dic={i : 0 for i in range(1,m+1)}
s1=[]
s2=[]
dq = deque()
for i in range(n):
    p,w = map(int,input().split())
    dic[p]+=1
    dq.append((p,w))

res=0
while m>0:
    p,w = dq.popleft()
    if p==m:
        while s1 and s1[-1]<w:
            res+=s1[-1]
            s2.append(s1.pop())
        res+=w
        s1.append(w)
        while s2:
            res+=s2[-1]
            s1.append(s2.pop())
        
        dic[m]-=1
        if dic[m]==0:
            m-=1
            s1=[]
    else:
        res+=w
        dq.append((p,w))
print(res)