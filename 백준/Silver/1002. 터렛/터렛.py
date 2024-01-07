n=int(input())
for _ in range(n):
    x1,y1,a,x2,y2,b=map(int,input().split())
    leng=(((x1-x2)**2)+((y1-y2)**2))**0.5
    if leng>(a+b) or abs(a-b)>leng:
        print(0)
    elif leng==0 and a==b:
        print(-1)
    elif leng==(a+b) or leng==abs(a-b):
        print(1)
    else:
        print(2)