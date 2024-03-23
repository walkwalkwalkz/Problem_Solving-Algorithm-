n=int(input())
st=input()
s=set(['a','e','i','o','u'])
res=0
for t in st:
    if t in s:
        res+=1
print(res)