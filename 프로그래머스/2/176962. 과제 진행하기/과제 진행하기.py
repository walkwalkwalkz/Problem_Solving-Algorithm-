def solution(plans):
    answer = []
    stack=[]
    
    for p in plans:
        p[1] = int(p[1][:2])*60 + int(p[1][3:])
        p[2] = int(p[2])
    
    plans.sort(key = lambda x : x[1])
    print(plans)
    
    for i in range(len(plans)-1):
        if(plans[i][1]+plans[i][2]==plans[i+1][1]):
            answer.append(plans[i][0])
        elif(plans[i][1]+plans[i][2]>plans[i+1][1]):
            stack.append([plans[i][0],plans[i][1]+plans[i][2]-plans[i+1][1]])
        else:
            tmp=plans[i+1][1]-(plans[i][1]+plans[i][2])
            answer.append(plans[i][0])
            while stack:
                name,time = stack.pop()
                if(time==tmp):
                    answer.append(name)
                    break
                elif(time>tmp):
                    stack.append([name,time-tmp])
                    break
                else:
                    tmp-=time
                    answer.append(name)
    
    answer.append(plans[-1][0])
    while stack:
        answer.append(stack.pop()[0])
                
    
    return answer