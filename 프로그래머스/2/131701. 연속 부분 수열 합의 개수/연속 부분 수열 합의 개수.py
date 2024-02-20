def solution(elements):
    answer = 0
    
    es=[]
    for i in range(len(elements)):
        es.append(elements[i:]+elements[:i])
    arr=[1]*(len(elements)*2)
    
    print(es)
    
    s=set()
    for e in elements:
        s.add(e)
    
    return answer