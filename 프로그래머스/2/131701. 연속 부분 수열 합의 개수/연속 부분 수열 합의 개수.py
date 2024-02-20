def solution(elements):
    s=set()
    for e in elements:
        s.add(e)

    es=elements+elements[:-1]

    for i in range(1,len(elements)):
        for j in range(len(es)-1,i-1,-1):
            es[j]=es[j-1]+elements[j%len(elements)]
            s.add(es[j])
    
    return len(s)