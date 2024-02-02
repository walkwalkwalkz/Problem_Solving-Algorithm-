from collections import deque

N,K = map(int,input().split())
arr=[i for i in range(1,N+1)]
arr=deque(arr)

for _ in range(K-1):
  arr.append(arr.popleft())
print(f'<{arr.popleft()}',end='')

while arr:
  for _ in range(K-1):
    arr.append(arr.popleft())
  print(f', {arr.popleft()}',end='')
print('>')