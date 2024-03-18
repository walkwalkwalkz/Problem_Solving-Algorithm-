from collections import deque

def bfs(a):
    dq=deque([(a,'')])

    while True:
        x,com=dq.popleft()

        if x==b:
            print(com)
            break

        tmp = x*2
        tmp = tmp%10000
        if visited[tmp]==0:
            visited[tmp]=1
            dq.append((tmp,com+'D'))
        
        tmp = x-1
        if tmp==-1:
            tmp=9999
        if visited[tmp]==0:
            visited[tmp]=1
            dq.append((tmp,com+'S'))

        tmp = x*10
        tmp = tmp + tmp//10000
        tmp = tmp % 10000
        if visited[tmp]==0:
            visited[tmp]=1
            dq.append((tmp,com+'L'))

        tmp = (x//10) + (x%10)*1000
        if visited[tmp]==0:
            visited[tmp]=1
            dq.append((tmp,com+'R'))

T=int(input())

for _ in range(T):
    a,b = map(int,input().split())
    visited=[0]*10000
    visited[a]=1
    bfs(a)