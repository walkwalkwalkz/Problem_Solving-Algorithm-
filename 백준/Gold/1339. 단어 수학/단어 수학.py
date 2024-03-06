N=int(input())
alphabets=[]

for _ in range(N):
    alphabets.append(input())

dict={}
for a in alphabets:
    for i in range(len(a)):
        if a[i] not in dict:
            dict[a[i]]=10**(len(a)-i-1)
        else:
            dict[a[i]]+=10**(len(a)-i-1)

tmp = sorted(dict.items(), key=lambda x:-x[1])

num=9
res=0
for _,value in tmp:
    res += num*value
    num-=1

print(res)