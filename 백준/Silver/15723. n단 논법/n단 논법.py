arr=[[0]*26 for _ in range(26)]

for _ in range(int(input())):
    tmp=input()
    arr[ord(tmp[0])-97][ord(tmp[-1])-97]=1
    

for i in range(26):
    for j in range(26):
        for k in range(26):
            if(arr[j][i]==1 and arr[i][k]==1):
                arr[j][k]=1

for _ in range(int(input())):
    tmp = input()
    if(arr[ord(tmp[0])-97][ord(tmp[-1])-97]==1):
        print("T")
    else:
        print("F")