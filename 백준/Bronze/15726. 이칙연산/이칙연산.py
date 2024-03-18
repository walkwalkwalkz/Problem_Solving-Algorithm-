a,b,c=map(int,input().split())
tmp1 = int(a*b/c)
tmp2 = int(a/b*c)
print(max(tmp1,tmp2))