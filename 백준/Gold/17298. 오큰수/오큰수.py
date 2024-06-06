n=int(input())
arr=list(map(int,input().split()))
s=[]
res=[]
for i in range(n-1,-1,-1):
    if len(s)==0:
        res.append(-1)
        s.append(arr[i])
    else:
        while len(s)!=0 and s[-1]<=arr[i]:
            s.pop()

        if len(s)==0:
            res.append(-1)
        else:
            res.append(s[-1])
        s.append(arr[i])
print(*(res[::-1]))