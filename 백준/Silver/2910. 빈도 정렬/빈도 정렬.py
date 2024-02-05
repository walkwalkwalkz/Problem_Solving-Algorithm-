n,c=map(int,input().split())
arr=list(map(int,input().split()))
dic={}

for a in arr:
  if a in dic:
    dic[a]+=1
  else:
    dic[a]=1

d = sorted(dic.items(), key=lambda x:x[1], reverse=True)

for key,value in d:
  for _ in range(value):
    print(key,end=' ')