a,b=input().split()
b=int(b)
cnt=0
for i in range(len(a)-1,-1,-1):
    if a[i]=='.':
        break
    cnt+=1

if a[0]=='0':
    a=str(int(a[-cnt:])**b)
    print('0.'+'0'*((b*cnt)-len(a))+a)
else:
    a=str(int(a[:-cnt-1]+a[-cnt:])**b)
    print(a[:-(cnt*b)]+'.'+a[-(cnt*b):])