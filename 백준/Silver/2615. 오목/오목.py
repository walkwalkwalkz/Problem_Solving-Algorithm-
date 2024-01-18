def rcheck(x,y):
  cnt=1
  while True:
    if y+cnt<19 and arr[x][y]==arr[x][y+cnt]:
      rCheck[x][y+cnt]=1
      cnt+=1
    else:
      break
  
  if cnt==5:
      print(arr[x][y])
      print(x+1,y+1)
      exit(0)

def ccheck(x,y):
  cnt=1
  while True:
    if x+cnt<19 and arr[x][y]==arr[x+cnt][y]:
      cCheck[x+cnt][y]=1
      cnt+=1
    else:
      break

  if cnt==5:
      print(arr[x][y])
      print(x+1,y+1)
      exit(0)

def dcheck(x,y):
  cnt=1
  while True:
    if x+cnt<19 and y+cnt<19 and arr[x][y]==arr[x+cnt][y+cnt]:
      dCheck[x+cnt][y+cnt]=1
      cnt+=1
    else:
      break

  if cnt==5:
      print(arr[x][y])
      print(x+1,y+1)
      exit(0)

def dcheck2(x,y):
  cnt=1
  while True:
    if 0<=y-cnt and x+cnt<19 and arr[x][y]==arr[x+cnt][y-cnt]:
      dCheck2[x+cnt][y-cnt]=1
      cnt+=1
    else:
      break

  if cnt==5:
      print(arr[x][y])
      print(x+1+4,y+1-4)
      exit(0)
  

arr=[list(map(int,input().split())) for _ in range(19)]

rCheck=[[0]*19 for _ in range(19)]
cCheck=[[0]*19 for _ in range(19)]
dCheck=[[0]*19 for _ in range(19)]
dCheck2=[[0]*19 for _ in range(19)]

for i in range(19):
  for j in range(19):
    if arr[i][j]==1 or arr[i][j]==2:
      if rCheck[i][j]==0:
        rcheck(i,j)
      if cCheck[i][j]==0:
        ccheck(i,j)
      if dCheck[i][j]==0:
        dcheck(i,j)
      if dCheck2[i][j]==0:
        dcheck2(i,j)

print(0)