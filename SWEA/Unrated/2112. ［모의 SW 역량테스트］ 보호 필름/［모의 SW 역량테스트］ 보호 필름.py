import copy

def check(arr):
    for j in range(w):
        cnt=1
        if cnt >= k:
            continue
        for i in range(1,d):
            if(d-i<k-cnt):
                return False
            if arr[i-1][j]==arr[i][j]:
                cnt+=1
                if cnt>=k:
                    break
            else:
                cnt=1
        else:
            break
    else:
        return True

    return False

def dfs(l):
    if(l==ii):
        # for i in range(ii):
        #     for j in range(w):
        #         brr[number[i]][j]=tmp[i]

        return check(arr)

    for i in range(2):
        # tmp[l]=i
        for j in range(w):
            arr[number[l]][j]=i
        if dfs(l+1): return True
        for j in range(w):
            arr[number[l]][j]=brr[number[l]][j]

    return False

def combi(idx,start):
    # global tmp
    if(idx==ii):
        # tmp=[0]*ii
        return dfs(0)

    for i in range(start,d):
        number[idx]=numbers[i]
        if(combi(idx+1,i+1)): return True

    return False

for tc in range(1,int(input())+1):
    d,w,k = map(int,input().split())
    arr=[list(map(int,input().split())) for _ in range(d)]
    brr = copy.deepcopy(arr)
    # tmp=[]
    numbers=[i for i in range(d)]
    for ii in range(k+1):
        number=[0]*ii
        if(combi(0,0)):
            print(f"#{tc} {ii}")
            break