from collections import deque

dx=[-1,1,0,0]
dy=[0,0,-1,1]

def dfs(L):
	global max
	if L==3:
		cnt=0
		for i in range(n):
			for j in range(m):
				if arr[i][j]==2:
					dq=deque()
					dq.append((i,j))
					while dq:
						now=dq.popleft()
						for k in range(4):
							xx = now[0]+dx[k]
							yy = now[1]+dy[k]
							if 0<=xx<n and 0<=yy<m and arr[xx][yy]==0:
								arr[xx][yy]=3
								dq.append((xx,yy))
		for i in range(n):
			for j in range(m):
				if arr[i][j]==0:
					cnt+=1
				elif arr[i][j]==3:
					arr[i][j]=0
		if cnt>max:
			max=cnt
	else:
		for i in range(n):
			for j in range(m):
				if arr[i][j]==0:
					arr[i][j]=1
					dfs(L+1)
					arr[i][j]=0
					
n,m=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
max=0
dfs(0)
print(max)