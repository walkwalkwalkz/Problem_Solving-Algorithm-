a,b,c=map(int,input().split())

def mul(num,n):
  if n==1:
    return num%c
  else:
    tmp=mul(num,n//2)
    if n%2==0:
      return((tmp*tmp)%c)
    else:
      return((tmp*tmp*num)%c)
      
print(mul(a,b))