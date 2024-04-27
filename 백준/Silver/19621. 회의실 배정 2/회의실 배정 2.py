n=int(input())
arr=[]
arr.append(list(map(int,input().split())))
if n==1:
    print(arr[-1][-1])
else:
    arr.append(list(map(int,input().split())))
    if n==2:
        print(max(arr[-2][-1],arr[-1][-1]))
    else:
        a,b,c = map(int,input().split())
        c+=arr[-2][-1]
        arr.append([a,b,c])
        if n==3:
            print(max(arr[-2][-1],arr[-1][-1]))
        else:
            for i in range(3,n):
                a,b,c = map(int,input().split())
                c+=max(arr[-2][-1],arr[-3][-1])
                arr.append([a,b,c])
            print(max(arr[-2][-1],arr[-1][-1]))