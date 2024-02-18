n=int(input())
ss=input()
alp=[0]*26
res=0

start=0
end=0
k=1
alp[ord(ss[0])-97]=1

while True:
    if k>n:
        alp[ord(ss[start])-97]-=1
        if alp[ord(ss[start])-97]==0:
            k-=1
        start+=1
    else:
        end+=1
        if end>=len(ss):
            break
        if alp[ord(ss[end])-97]==0:
            k+=1
        alp[ord(ss[end])-97]+=1

        if k<=n and end-start+1>res:
            res=end-start+1
print(res)