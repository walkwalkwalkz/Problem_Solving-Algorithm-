pw = input()

if(pw[0]=='0'):
    print(0)
else:
    dp=[0]*(len(pw)+1)
    dp[0]=1
    dp[1]=1
    for i in range(1,len(pw)):
        if pw[i]!='0':
            dp[i+1]+=dp[i]%1000000
        if pw[i-1]!='0' and int(pw[i-1:i+1])<=26:
            dp[i+1]+=dp[i-1]%1000000
    print(dp[-1]%1000000)