def subset1(l,sum):
    if sum>C:
        return

    if l==M:
        global maxw1
        ssum = 0
        for i in range(M):
            if isSelected[i] == 1:
                ssum += w1[i] * w1[i]
        if maxw1 < ssum:
            maxw1 = ssum
        return



    isSelected[l]=1
    subset1(l+1,sum+w1[l])

    isSelected[l]=0
    subset1(l+1,sum)


def subset2(l, sum):
    if sum > C:
        return

    if l == M:
        global maxw2
        ssum = 0
        for i in range(M):
            if isSelected[i] == 1:
                ssum += w2[i] * w2[i]
        if maxw2 < ssum:
            maxw2 = ssum

        return

    isSelected[l] = 1
    subset2(l + 1, sum + w2[l])

    isSelected[l] = 0
    subset2(l + 1, sum)


for t in range(1,int(input())+1):
    N,M,C = map(int,input().split())
    arr=[list(map(int,input().split())) for _ in range(N)]
    res=0
    # w1 결정
    for i in range(N):
        for j in range(N-M+1):
            w1 = []
            w1=arr[i][j:j+M]
            isSelected=[0]*M
            flag=0
            maxw1=0
            subset1(0,0)

            # w2 결정
            flag=1
            maxw2 = 0
            for m in range(j+M,N-M+1):
                isSelected = [0] * M
                w2=arr[i][m:m+M]
                subset2(0, 0)

            for k in range(i+1,N):
                for l in range(N-M+1):
                    isSelected = [0] * M
                    w2=arr[k][l:l+M]
                    subset2(0, 0)

            if res<maxw1+maxw2:
                res=maxw1+maxw2

    print(f"#{t} {res}")
