h1,w1 = map(int,input().split())
arr1=[list(input()) for _ in range(h1)]

h2,w2 = map(int,input().split())
arr2=[list(input()) for _ in range(h2)]

for _ in range(h1):
    arr2=[['.']*w2]+arr2
for _ in range(h2):
    arr1+=[['.']*w1]

for _ in range(w1):
    for i in range(len(arr2)):
        arr2[i]=['.']+arr2[i]
for _ in range(w2):
    for i in range(len(arr1)):
        arr1[i].append('.')

r=0
for i in range(h1):
    for j in range(w1):
        if arr1[i][j]=='O':
            r+=1

res=0
for gi in range(1,h1+h2+1):
    for gj in range(1,w1+w2+1):
        tmp=0
        for i in range(gi):
            for j in range(gj):
                if arr1[i][j]=='O' and arr2[h2+h1-gi+i][w2+w1-gj+j]=='O':
                    tmp+=1
        if res<tmp:
            res=tmp

print(r-res)