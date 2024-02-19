def solution(k, tangerine):
    answer = 0
    
    dic={}
    for t in tangerine:
        if t in dic:
            dic[t]+=1
        else:
            dic[t]=1
            
    arr=list(dic.items())
    arr.sort(key = lambda x : (-x[1]))
    
    for _,b in arr:
        k-=b
        answer+=1
        if k<=0:
            break
    
    return answer