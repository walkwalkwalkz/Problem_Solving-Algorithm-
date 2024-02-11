n=int(input())
arr=[]

for _ in range(n):
    d,t = map(int,input().split())
    arr.append((d,t))

arr.sort(key = lambda x : (-x[1]))

day=1000000000
for i in range(n):
    if arr[i][1]<day:
        day=arr[i][1]-arr[i][0]
    else:
        day-=arr[i][0]
print(day)