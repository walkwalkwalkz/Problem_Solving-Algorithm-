from itertools import combinations

def onCount(n):
    cnt=0
    for nn in n:
        if int(nn)%2==1:
            cnt+=1
    return cnt

def onHolic(n,cnt):
    leng = len(n)
    cnt+=onCount(n)

    if leng==1:
        global maxVal,minVal
        if maxVal<cnt:
            maxVal=cnt
        if minVal>cnt:
            minVal=cnt
        return

    if leng==2:
        onHolic(str(int(n[0])+int(n[1])),cnt)
    else:
        for a,b in combinations([i for i in range(1,leng)],2):
            onHolic(str(int(n[:a])+int(n[a:b])+int(n[b:])),cnt)

n=int(input())
maxVal=0
minVal=60
onHolic(str(n),0)
print(minVal,maxVal)