def down(olist,clist):
    for j in range(n):
        s=[]
        idx=n-1
        for i in range(n-1,-1,-1):
            if olist[i][j]==0: continue
            if not s:
                s.append(olist[i][j])
            else:
                if s[0]!=olist[i][j]:
                    clist[idx][j]=s.pop()
                    s.append(olist[i][j])
                else:
                    clist[idx][j]=s.pop()*2
                idx-=1
        if s:
            clist[idx][j]=s.pop()

def up(olist,clist):
    for j in range(n):
        s=[]
        idx=0
        for i in range(n):
            if olist[i][j]==0: continue
            if not s:
                s.append(olist[i][j])
            else:
                if s[0]!=olist[i][j]:
                    clist[idx][j]=s.pop()
                    s.append(olist[i][j])
                else:
                    clist[idx][j]=s.pop()*2
                idx+=1
        if s:
            clist[idx][j]=s.pop()

def left(olist,clist):
    for i in range(n):
        s=[]
        idx=0
        for j in range(n):
            if olist[i][j]==0: continue
            if not s:
                s.append(olist[i][j])
            else:
                if s[0]!=olist[i][j]:
                    clist[i][idx]=s.pop()
                    s.append(olist[i][j])
                else:
                    clist[i][idx]=s.pop()*2
                idx+=1
        if s:
            clist[i][idx]=s.pop()

def right(olist,clist):
    for i in range(n):
        s=[]
        idx=n-1
        for j in range(n-1,-1,-1):
            if olist[i][j]==0: continue
            if not s:
                s.append(olist[i][j])
            else:
                if s[0]!=olist[i][j]:
                    clist[i][idx]=s.pop()
                    s.append(olist[i][j])
                else:
                    clist[i][idx]=s.pop()*2
                idx-=1
        if s:
            clist[i][idx]=s.pop()

def check():
    global res
    for i in range(n):
        for j in range(n):
            if arr5[i][j]>res:
                # for a in arr:
                #     print(a)
                # print()
                # for a in arr1:
                #     print(a)
                # print()
                # for a in arr2:
                #     print(a)
                # print()
                # for a in arr3:
                #     print(a)
                # print()
                # for a in arr4:
                #     print(a)
                # print()
                # for a in arr5:
                #     print(a)
                # print()
                # print()
                # print()
                res=arr5[i][j]



n=int(input())
arr=[list(map(int,input().split())) for _ in range(n)]
res=0
for i in range(4):
    arr1=[[0]*n for _ in range(n)]
    if i==0:
        down(arr,arr1)
    elif i==1:
        up(arr,arr1)
    elif i==2:
        right(arr,arr1)
    else:
        left(arr,arr1)
    for j in range(4):
        arr2 = [[0] * n for _ in range(n)]
        if j == 0:
            down(arr1, arr2)
        elif j == 1:
            up(arr1, arr2)
        elif j == 2:
            right(arr1, arr2)
        else:
            left(arr1, arr2)
        for k in range(4):
            arr3 = [[0] * n for _ in range(n)]
            if k == 0:
                down(arr2, arr3)
            elif k == 1:
                up(arr2, arr3)
            elif k == 2:
                right(arr2, arr3)
            else:
                left(arr2, arr3)
            for l in range(4):
                arr4 = [[0] * n for _ in range(n)]
                if l == 0:
                    down(arr3, arr4)
                elif l == 1:
                    up(arr3, arr4)
                elif l == 2:
                    right(arr3, arr4)
                else:
                    left(arr3, arr4)
                for m in range(4):
                    arr5 = [[0] * n for _ in range(n)]
                    if m == 0:
                        down(arr4, arr5)
                    elif m == 1:
                        up(arr4, arr5)
                    elif m == 2:
                        right(arr4, arr5)
                    else:
                        left(arr4, arr5)
                    check()
print(res)