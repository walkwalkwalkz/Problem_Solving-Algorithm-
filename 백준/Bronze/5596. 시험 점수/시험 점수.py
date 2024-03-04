arr1=list(map(int,input().split()))
arr2=list(map(int,input().split()))
if(sum(arr1)>sum(arr2)):
    print(sum(arr1))
else:
    print(sum(arr2))