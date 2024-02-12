n,k=map(int,input().split())

arr=[]
fir=int(input())
pre=fir
cur=fir
for _ in range(n-1):
    cur=int(input())
    arr.append(cur-pre-1)
    pre=cur
tot = cur-fir+1

if k==1:
    print(tot)
elif n==k:
    print(n)
else:
    arr.sort(reverse=True)
    for i in range(k-1):
        tot-=arr[i]
    print(tot)