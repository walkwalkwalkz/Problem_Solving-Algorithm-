n,l=map(int,input().split())
arr=[]
for _ in range(n):
    a,b=map(int,input().split())
    arr.append([a,b])
arr.sort()

res=0
tmp=arr[0][0]-1
for i in range(n):
    if tmp<arr[i][1]:
        if arr[i][0]<=tmp:
            arr[i][0]=tmp+1
        rem=(arr[i][1]-arr[i][0])%l
        res+=(arr[i][1]-arr[i][0])//l
        if rem!=0:
            res+=1
            tmp=arr[i][1]+(l-rem)-1

print(res)