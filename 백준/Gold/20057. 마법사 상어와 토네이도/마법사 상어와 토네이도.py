#백준 마법사상어와토네이도 20057
dx=[0,1,0,-1]
dy=[-1,0,1,0]

def leftper():
    global res
    tmp=0

    #1 5%
    tmpx=sx
    tmpy=sy-2
    if 0<=tmpx<n and 0<=tmpy<n:
        arr[tmpx][tmpy]+=int(arr[sx][sy]*0.05)
    else:
        res+=int(arr[sx][sy]*0.05)
    tmp+=int(arr[sx][sy]*0.05)

    #2 10%
    tmpx = sx - 1
    tmpy = sy - 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.1)
    else:
        res += int(arr[sx][sy] * 0.1)
    tmp += int(arr[sx][sy] * 0.1)

    #3 10%
    tmpx = sx + 1
    tmpy = sy - 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.1)
    else:
        res += int(arr[sx][sy] * 0.1)
    tmp += int(arr[sx][sy] * 0.1)

    #4 2%
    tmpx = sx - 2
    tmpy = sy
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.02)
    else:
        res += int(arr[sx][sy] * 0.02)
    tmp += int(arr[sx][sy] * 0.02)

    #5 7%
    tmpx = sx - 1
    tmpy = sy
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.07)
    else:
        res += int(arr[sx][sy] * 0.07)
    tmp += int(arr[sx][sy] * 0.07)

    #6 7%
    tmpx = sx + 1
    tmpy = sy
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.07)
    else:
        res += int(arr[sx][sy] * 0.07)
    tmp += int(arr[sx][sy] * 0.07)

    #7 2%
    tmpx = sx + 2
    tmpy = sy
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.02)
    else:
        res += int(arr[sx][sy] * 0.02)
    tmp += int(arr[sx][sy] * 0.02)

    #8 1%
    tmpx = sx - 1
    tmpy = sy + 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.01)
    else:
        res += int(arr[sx][sy] * 0.01)
    tmp += int(arr[sx][sy] * 0.01)

    #9 1%
    tmpx = sx + 1
    tmpy = sy + 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.01)
    else:
        res += int(arr[sx][sy] * 0.01)
    tmp += int(arr[sx][sy] * 0.01)

    # print("tmp: ",tmp)
    if sy-1>=0:
        arr[sx][sy-1]+=arr[sx][sy]-tmp
    else:
        res+=arr[sx][sy]-tmp

def downper():
    global res
    tmp = 0

    # 1 5%
    tmpx = sx +2
    tmpy = sy
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.05)
    else:
        res += int(arr[sx][sy] * 0.05)
    tmp += int(arr[sx][sy] * 0.05)

    # 2 10%
    tmpx = sx + 1
    tmpy = sy - 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.1)
    else:
        res += int(arr[sx][sy] * 0.1)
    tmp += int(arr[sx][sy] * 0.1)

    # 3 10%
    tmpx = sx + 1
    tmpy = sy + 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.1)
    else:
        res += int(arr[sx][sy] * 0.1)
    tmp += int(arr[sx][sy] * 0.1)

    # 4 2%
    tmpx = sx
    tmpy = sy - 2
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.02)
    else:
        res += int(arr[sx][sy] * 0.02)
    tmp += int(arr[sx][sy] * 0.02)

    # 5 7%
    tmpx = sx
    tmpy = sy - 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.07)
    else:
        res += int(arr[sx][sy] * 0.07)
    tmp += int(arr[sx][sy] * 0.07)

    # 6 7%
    tmpx = sx
    tmpy = sy + 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.07)
    else:
        res += int(arr[sx][sy] * 0.07)
    tmp += int(arr[sx][sy] * 0.07)

    # 7 2%
    tmpx = sx
    tmpy = sy + 2
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.02)
    else:
        res += int(arr[sx][sy] * 0.02)
    tmp += int(arr[sx][sy] * 0.02)

    # 8 1%
    tmpx = sx - 1
    tmpy = sy - 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.01)
    else:
        res += int(arr[sx][sy] * 0.01)
    tmp += int(arr[sx][sy] * 0.01)

    # 9 1%
    tmpx = sx - 1
    tmpy = sy + 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.01)
    else:
        res += int(arr[sx][sy] * 0.01)
    tmp += int(arr[sx][sy] * 0.01)

    # print("tmp: ", tmp)
    if sx+1<n:
        arr[sx+1][sy] += arr[sx][sy] - tmp
    else:
        res += arr[sx][sy] - tmp

def rightper():
    global res
    tmp = 0

    # 1 5%
    tmpx = sx
    tmpy = sy + 2
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.05)
    else:
        res += int(arr[sx][sy] * 0.05)
    tmp += int(arr[sx][sy] * 0.05)

    # 2 10%
    tmpx = sx + 1
    tmpy = sy + 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.1)
    else:
        res += int(arr[sx][sy] * 0.1)
    tmp += int(arr[sx][sy] * 0.1)

    # 3 10%
    tmpx = sx - 1
    tmpy = sy + 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.1)
    else:
        res += int(arr[sx][sy] * 0.1)
    tmp += int(arr[sx][sy] * 0.1)

    # 4 2%
    tmpx = sx + 2
    tmpy = sy
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.02)
    else:
        res += int(arr[sx][sy] * 0.02)
    tmp += int(arr[sx][sy] * 0.02)

    # 5 7%
    tmpx = sx + 1
    tmpy = sy
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.07)
    else:
        res += int(arr[sx][sy] * 0.07)
    tmp += int(arr[sx][sy] * 0.07)

    # 6 7%
    tmpx = sx - 1
    tmpy = sy
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.07)
    else:
        res += int(arr[sx][sy] * 0.07)
    tmp += int(arr[sx][sy] * 0.07)

    # 7 2%
    tmpx = sx - 2
    tmpy = sy
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.02)
    else:
        res += int(arr[sx][sy] * 0.02)
    tmp += int(arr[sx][sy] * 0.02)

    # 8 1%
    tmpx = sx + 1
    tmpy = sy - 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.01)
    else:
        res += int(arr[sx][sy] * 0.01)
    tmp += int(arr[sx][sy] * 0.01)

    # 9 1%
    tmpx = sx - 1
    tmpy = sy - 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.01)
    else:
        res += int(arr[sx][sy] * 0.01)
    tmp += int(arr[sx][sy] * 0.01)

    # print("tmp: ", tmp)
    if sy+1<n:
        arr[sx][sy + 1] += arr[sx][sy] - tmp
    else:
        res += arr[sx][sy] - tmp

def upper():
    global res
    tmp = 0

    # 1 5%
    tmpx = sx - 2
    tmpy = sy
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.05)
    else:
        res += int(arr[sx][sy] * 0.05)
    tmp += int(arr[sx][sy] * 0.05)

    # 2 10%
    tmpx = sx - 1
    tmpy = sy + 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.1)
    else:
        res += int(arr[sx][sy] * 0.1)
    tmp += int(arr[sx][sy] * 0.1)

    # 3 10%
    tmpx = sx - 1
    tmpy = sy - 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.1)
    else:
        res += int(arr[sx][sy] * 0.1)
    tmp += int(arr[sx][sy] * 0.1)

    # 4 2%
    tmpx = sx
    tmpy = sy - 2
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.02)
    else:
        res += int(arr[sx][sy] * 0.02)
    tmp += int(arr[sx][sy] * 0.02)

    # 5 7%
    tmpx = sx
    tmpy = sy - 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.07)
    else:
        res += int(arr[sx][sy] * 0.07)
    tmp += int(arr[sx][sy] * 0.07)

    # 6 7%
    tmpx = sx
    tmpy = sy + 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.07)
    else:
        res += int(arr[sx][sy] * 0.07)
    tmp += int(arr[sx][sy] * 0.07)

    # 7 2%
    tmpx = sx
    tmpy = sy + 2
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.02)
    else:
        res += int(arr[sx][sy] * 0.02)
    tmp += int(arr[sx][sy] * 0.02)

    # 8 1%
    tmpx = sx + 1
    tmpy = sy - 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.01)
    else:
        res += int(arr[sx][sy] * 0.01)
    tmp += int(arr[sx][sy] * 0.01)

    # 9 1%
    tmpx = sx + 1
    tmpy = sy + 1
    if 0 <= tmpx < n and 0 <= tmpy < n:
        arr[tmpx][tmpy] += int(arr[sx][sy] * 0.01)
    else:
        res += int(arr[sx][sy] * 0.01)
    tmp += int(arr[sx][sy] * 0.01)

    # print("tmp: ", tmp)
    if sx-1>=0:
        arr[sx-1][sy] += arr[sx][sy] - tmp
    else:
        res += arr[sx][sy] - tmp

n=int(input())
arr=[list(map(int,input().split())) for _ in range(n)]

sx=n//2
sy=n//2
# print(sx,sy)
di=0
res=0
for i in range(1,n):
    for _ in range(i):
        sx=sx+dx[di]
        sy=sy+dy[di]
        if di==0:
            leftper()
        elif di==1:
            downper()
        elif di==2:
            rightper()
        else:
            upper()
        arr[sx][sy]=0
        # print(sx,sy)
        # for a in arr:
        #     print(a)
        # print(res)
        # print()

    di=(di+1)%4
    for _ in range(i):
        sx = sx + dx[di]
        sy = sy + dy[di]
        if di==0:
            leftper()
        elif di==1:
            downper()
        elif di==2:
            rightper()
        else:
            upper()
        arr[sx][sy] = 0
        # print(sx, sy)
        # for a in arr:
        #     print(a)
        # print(res)
        # print()
    di = (di + 1) % 4

#마지막은 n-1만큼 왼쪽으로 ㄱㄱ
for _ in range(n):
    sx = sx + dx[di]
    sy = sy + dy[di]
    if di == 0:
        leftper()
    elif di == 1:
        downper()
    elif di == 2:
        rightper()
    else:
        upper()
    arr[sx][sy] = 0
    # print(sx, sy)
    # for a in arr:
    #     print(a)
    # print(res)
    # print()

print(res)