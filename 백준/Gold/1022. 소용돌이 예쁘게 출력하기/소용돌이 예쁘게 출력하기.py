def placevalue(num):
    cnt=0
    while(num):
        num=num//10
        cnt+=1
    return cnt


# arr=[[0]*10001 for _ in range(10001)]
r1,c1,r2,c2 = map(int,input().split())
end=max(abs(r1),abs(c1),abs(r2),abs(c2))
c=c2-c1+1
r=r2-r1+1
arr=[[0]*(c) for _ in range(r)]

r1+=5000
c1+=5000
r2+=5000
c2+=5000

start=0
size=3
x=5000
y=5000
if(0<=x-r1<r and 0<=y-c1<c):
    arr[x-r1][y-c1]=1
tmp=1
while(start<=end):
    tmp+=1
    y+=1
    if(0<=x-r1<r and 0<=y-c1<c):
        arr[x-r1][y-c1]=tmp

    for _ in range(size-2):
        tmp+=1
        x-=1
        if(0<=x-r1<r and 0<=y-c1<c):
            arr[x-r1][y-c1]=tmp
    
    for _ in range(size-1):
        tmp+=1
        y-=1
        if(0<=x-r1<r and 0<=y-c1<c):
            arr[x-r1][y-c1]=tmp
    
    for _ in range(size-1):
        tmp+=1
        x+=1
        if(0<=x-r1<r and 0<=y-c1<c):
            arr[x-r1][y-c1]=tmp
    
    for _ in range(size-1):
        tmp+=1
        y+=1
        if(0<=x-r1<r and 0<=y-c1<c):
            arr[x-r1][y-c1]=tmp
    start+=1
    size+=2

maxVal=0
for i in range(r):
    for j in range(c):
        if maxVal<arr[i][j]:
            maxVal=arr[i][j]
maxpv=placevalue(maxVal)

for i in range(r):
    for j in range(c):
        tmp = maxpv-placevalue(arr[i][j])
        print(' '*tmp,end='')
        print(arr[i][j],end=' ')
    print()