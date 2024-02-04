n=int(input())
s=input()
res=500000

blue=0
red=0
for ss in s:
    if ss=='R':
        red+=1
    else:
        blue+=1

l=1
while(l<n and s[l-1]==s[l]):
    l+=1
if(s[l-1]=='R'):
    if(res>red-l):
        res=red-l
else:
    if(res>blue-l):
        res=blue-l

r=1
while(r+1<=n and s[n-(r+1)]==s[n-r]):
    r+=1
if(s[-1]=='R'):
    if(res>red-r):
        res=red-r
else:
    if(res>blue-r):
        res=blue-r

print(min(res,red,blue))