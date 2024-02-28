days=[0,31,28,31,30,31,30,31,31,30,31,30,31]

n=int(input())
arr=[]

for _ in range(n):
    tom,tod,fromm,fromd = map(int,input().split())
    if(fromm<3|tom>=12): continue
    t = tom*31+tod
    if(fromd==days[fromm]): fromd=31
    f = fromm*31+fromd
    arr.append((t,f))

end = 94
arr.sort(key = lambda x : (x[0],x[1]))
maxend=0
res=0

i=0
while(i<len(arr)):
    if(arr[i][0]<=end):
        if(maxend<arr[i][1]):
            maxend = arr[i][1]
            if(maxend>372): break
    else:
        if(maxend==0):
            res=0 
            break
        end=maxend
        maxend=0
        i-=1
        res+=1
    i+=1

if(maxend<=372):
    print(0)
else:
    # print(maxend)
    print(res+1)