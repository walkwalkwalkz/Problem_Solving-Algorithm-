N=int(input())

arr1=list(map(int,input().split()))
arr2=list(set(arr1))
arr2.sort()

dic={}
for i in range(len(arr2)):
    dic[arr2[i]]=i

for a in arr1:
    print(dic[a],end=' ')