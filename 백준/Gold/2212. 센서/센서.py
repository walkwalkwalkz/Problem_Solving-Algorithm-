N=int(input())
K=int(input())
if N<=K:
    print(0)
else:
    arr=list(map(int,input().split()))
    arr.sort()
    gap=[]

    for i in range(N-1):
        gap.append(arr[i+1]-arr[i])
    gap.sort()

    res=arr[-1]-arr[0]
    for i in range(N-2,N-1-K,-1):
        res-=gap[i]
    print(res)