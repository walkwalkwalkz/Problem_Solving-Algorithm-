from collections import deque

n=int(input())
arr=[['.']+list(input())+['.'] for _ in range(2)]

res=0
dq = deque([(1,-1,0)])
while dq:
    x,pre,cnt = dq.popleft()

    if x==n+1:
        if res<cnt:
            res=cnt
        continue
    
    tmp=0
    if pre==-1:
        if arr[1][x]!='#' and arr[0][x]=='.' and arr[0][x+1]=='.':
            dq.append((x+1,1,cnt+1))
            tmp=1
        if arr[0][x]!='#' and arr[1][x]=='.' and arr[1][x+1]=='.':
            dq.append((x+1,0,cnt+1))
            tmp=1
    elif pre==0:
        if arr[0][x]!='#' and arr[1][x]=='.' and arr[1][x+1]=='.':
            dq.append((x+1,0,cnt+1))
            tmp=1
    elif pre==1:
        if arr[1][x]!='#' and arr[0][x]=='.' and arr[0][x+1]=='.':
            dq.append((x+1,1,cnt+1))
            tmp=1

    if tmp==0:
        if arr[0][x]=='#':
            dq.append((x+1,0,cnt))
        elif arr[1][x]=='#':
            dq.append((x+1,1,cnt))
        else:
            dq.append((x+1,-1,cnt))

print(res)