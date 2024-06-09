from collections import deque

dx=[-1,1,0,0]
dy=[0,0,-1,1]

n,m = map(int,input().split())
arr=[list(input()) for _ in range(n)]
sx,sy=0,0

for i in range(n):
    for j in range(m):
        if arr[i][j]=='@':
            arr[i][j]='.'
            sx,sy=i,j

dq = deque()
res1=0

xx = sx - 1
if 0<=xx and arr[xx][sy]!='|':
    if arr[xx][sy]=='*':
        dq.append((xx,sy))
        arr[xx][sy] = '.'
        res1+=1
    elif arr[xx][sy]=='#':
        arr[xx][sy]='*'

    xx = xx - 1
    if 0 <= xx and arr[xx][sy] != '|':
        if arr[xx][sy] == '*':
            dq.append((xx, sy))
            arr[xx][sy] = '.'
            res1 += 1
        elif arr[xx][sy] == '#':
            arr[xx][sy] = '*'

xx = sx + 1
if xx < n and arr[xx][sy] != '|':
    if arr[xx][sy] == '*':
        dq.append((xx, sy))
        arr[xx][sy] = '.'
        res1 += 1
    elif arr[xx][sy] == '#':
        arr[xx][sy] = '*'

    xx = xx + 1
    if xx < n and arr[xx][sy] != '|':
        if arr[xx][sy] == '*':
            dq.append((xx, sy))
            arr[xx][sy] = '.'
            res1 += 1
        elif arr[xx][sy] == '#':
            arr[xx][sy] = '*'

yy = sy - 1
if 0 <= yy and arr[sx][yy] != '|':
    if arr[sx][yy] == '*':
        dq.append((sx, yy))
        arr[sx][yy] = '.'
        res1 += 1
    elif arr[sx][yy] == '#':
        arr[sx][yy] = '*'

    yy = yy - 1
    if 0 <= yy and arr[sx][yy] != '|':
        if arr[sx][yy] == '*':
            dq.append((sx, yy))
            arr[sx][yy] = '.'
            res1 += 1
        elif arr[sx][yy] == '#':
            arr[sx][yy] = '*'

yy = sy + 1
if yy<m and arr[sx][yy] != '|':
    if arr[sx][yy] == '*':
        dq.append((sx, yy))
        arr[sx][yy] = '.'
        res1 += 1
    elif arr[sx][yy] == '#':
        arr[sx][yy] = '*'

    yy = yy + 1
    if yy<m and arr[sx][yy] != '|':
        if arr[sx][yy] == '*':
            dq.append((sx, yy))
            arr[sx][yy] = '.'
            res1 += 1
        elif arr[sx][yy] == '#':
            arr[sx][yy] = '*'

while dq:
    sx,sy = dq.popleft()

    xx = sx - 1
    if 0 <= xx and arr[xx][sy] != '|':
        if arr[xx][sy] == '*':
            dq.append((xx, sy))
            arr[xx][sy] = '.'
            res1 += 1
        elif arr[xx][sy] == '#':
            arr[xx][sy] = '*'

    xx = sx + 1
    if xx < n and arr[xx][sy] != '|':
        if arr[xx][sy] == '*':
            dq.append((xx, sy))
            arr[xx][sy] = '.'
            res1 += 1
        elif arr[xx][sy] == '#':
            arr[xx][sy] = '*'

    yy = sy - 1
    if 0 <= yy and arr[sx][yy] != '|':
        if arr[sx][yy] == '*':
            dq.append((sx, yy))
            arr[sx][yy] = '.'
            res1 += 1
        elif arr[sx][yy] == '#':
            arr[sx][yy] = '*'

    yy = sy + 1
    if yy < m and arr[sx][yy] != '|':
        if arr[sx][yy] == '*':
            dq.append((sx, yy))
            arr[sx][yy] = '.'
            res1 += 1
        elif arr[sx][yy] == '#':
            arr[sx][yy] = '*'

res2=0
for i in range(n):
    for j in range(m):
        if arr[i][j]=='*' or arr[i][j]=='#':
            res2+=1

print(res1,res2)