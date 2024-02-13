def solution(sequence, k):
    answer = [0,len(sequence)]
    start=0
    end=0
    sum=sequence[0]
    
    while(True):
        if sum==k and end-start<answer[1]-answer[0]:
            answer[0]=start
            answer[1]=end
            
        if sum<=k or start==end:
            end+=1
            if end==len(sequence):
                break
            sum+=sequence[end]
        else:
            sum-=sequence[start]
            start+=1
        
    return answer