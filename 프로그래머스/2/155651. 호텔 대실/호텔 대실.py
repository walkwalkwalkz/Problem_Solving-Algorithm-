def solution(book_time):
    answer = 0
    
    arr=[]
    for i in range(len(book_time)):
        arr.append(((int(book_time[i][0][:2])*60)+(int(book_time[i][0][3:])),(int(book_time[i][1][:2])*60)+(int(book_time[i][1][3:])+10)))
    arr.sort()
    
    visited=[0]*len(arr)
    cnt=len(arr)
    
    while(cnt>0):
        end=0
        for i in range(len(arr)):
            if arr[i][0]>=end and visited[i]==0:
                end=arr[i][1]
                visited[i]=1
                cnt-=1
        answer+=1
           
    return answer