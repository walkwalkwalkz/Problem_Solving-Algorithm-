def dfs(l,ls):
    global res
    if l==leng:
        res+=1
        return
    
    for k in dic.keys():
        if ls[-1]!=k and dic[k]!=0:
            dic[k]-=1
            dfs(l+1,ls+k)
            dic[k]+=1


s=input()
dic={}
leng = len(s)
res=0

for ss in s:
    if ss in dic:
        dic[ss]+=1
    else:
        dic[ss]=1

for k in dic.keys():
    dic[k]-=1
    dfs(1,k)
    dic[k]+=1
print(res)