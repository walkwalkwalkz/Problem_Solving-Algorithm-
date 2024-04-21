n=int(input())
cra=list(map(int,input().split()))
m=int(input())
box=list(map(int,input().split()))

cra.sort(reverse=True)
box.sort(reverse=True)

if box[0]>cra[0]:
  print(-1)
else:
  res=0
  while box:
    for i in range(n):
      for j in range(len(box)):
        if cra[i]>=box[j]:
          box.pop(j)
          break
    res+=1
  print(res)