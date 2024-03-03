a,b,c=map(int,input().split())
tmp=a*b

if(c>=tmp): 
    print(0)
else:
    print(tmp-c)