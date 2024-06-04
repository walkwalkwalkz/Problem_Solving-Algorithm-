n=int(input())
arr=[]
order=[]
for _ in range(n):
    tmp=list(input().split(" "))
    for i in range(5):
        if len(tmp[i])==4:
            tmp[i]= tmp[i][:2]+"0"+tmp[i][-2:]
        elif len(tmp[i])==3:
            tmp[i] = tmp[i][:2]+"00"+tmp[i][-1]
    arr+=tmp
    order+=tmp
order.sort()

s=[]
i=0
flag=0
for j in range(len(order)):
    if s and order[j]==s[-1]:
        s.pop()
        continue

    while i<len(arr) and order[j]!=arr[i]:
        s.append(arr[i])
        i+=1
    i+=1
    if i>=len(arr):
        if order[j+1:]==s[::-1]:
            flag=1
        break

if flag==1:
    print("GOOD")
else:
    print("BAD")