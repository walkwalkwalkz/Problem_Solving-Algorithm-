n=int(input())
arr=list(map(int,input().split()))
arr.sort()

min=200000
for i in range(n):
    if min>arr[i]+arr[-(i+1)]:
        min = arr[i]+arr[-(i+1)]
print(min)