import sys

def perm(cnt,w):
    if w in s:
        return
    else:
        s.add(w)
    
    if cnt==len(word):
        print(w)
        return
    
    for i in range(len(word)):
        if isSelected[i]==1:
            continue
        isSelected[i]=1
        perm(cnt+1,w+word[i])
        isSelected[i]=0

n=int(sys.stdin.readline())

for _ in range(n):
    word=list(sys.stdin.readline())[:-1]
    word.sort()
    s=set()
    isSelected=[0]*len(word)
    perm(0,'')