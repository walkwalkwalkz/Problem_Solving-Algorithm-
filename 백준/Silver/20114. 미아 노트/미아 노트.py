from sys import stdin

n, h, w = map(int, stdin.readline().split())
arr = [list(stdin.readline().rstrip()) for _ in range(h)]


def solve(x):
    global ans
    for i in range(x * w, (x + 1) * w):
        for j in range(h):
            if arr[j][i] != '?':
                ans += arr[j][i]
                return
    ans += '?'
    return


ans = ''
for i in range(n):
    solve(i)
print(ans)