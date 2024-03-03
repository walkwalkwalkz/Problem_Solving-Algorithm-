def cal():
    global max
    global min

    sum=numbers[0]

    for i in range(1,len(numbers)):
        if datas[i-1]==0:
            sum+=numbers[i]
        elif datas[i-1]==1:
            sum-=numbers[i]
        elif datas[i-1]==2:
            sum*=numbers[i]
        else:
            if(sum<0):
                sum=-((-sum)//numbers[i])
            else:
                sum//=numbers[i]

    if(max<sum):
        max=sum
    if(sum<min):
        min=sum

def np():
    N=len(datas)-1

    i=N
    while(i>0 and datas[i-1]>=datas[i]): i-=1

    if(i==0): return False

    j=N
    while(datas[i-1]>=datas[j]): j-=1

    datas[i-1],datas[j]=datas[j],datas[i-1]

    k=N
    while(i<k):
        datas[i], datas[k] = datas[k], datas[i]
        i += 1
        k -= 1

    return True

for t in range(1,int(input())+1):
    N=int(input())
    tx=list(map(int,input().split()))
    datas=[]
    for i in range(4):
        datas+=[i]*tx[i]

    numbers=list(map(int,input().split()))

    max = -100000000
    min = 100000000

    cal()
    while(np()):
        cal()

    print(f"#{t} {max-min}")