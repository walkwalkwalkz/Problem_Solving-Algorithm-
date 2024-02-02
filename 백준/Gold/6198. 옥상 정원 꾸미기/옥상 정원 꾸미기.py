n=int(input())
s=[]
s.append(int(input()))

res=0
for _ in range(n-1):
    tmp=int(input())
    while s:
        if s[-1]>tmp:
            break
        s.pop()
    res+=len(s)
    s.append(tmp)
print(res)