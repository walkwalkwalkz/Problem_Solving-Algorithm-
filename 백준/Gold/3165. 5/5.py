n,k = map(int,input().split())
n+=1
n=list(str(n))
idx = len(n)-1
while idx>=0:
    if(n.count('5')>=k):
        break

    if(n[idx]=='5'):
        idx-=1
    elif(n[idx]<'5'):
        n[idx]='5'
        idx-=1
    else:
        n="".join(n)
        leng=len(n)
        n=int("".join(n))
        tmp=leng-idx
        n+=10**tmp
        n=list(str(n))
        n[idx-leng]='0'
        idx = len(n)+idx-leng

print((k-n.count('5'))*'5'+''.join(n))