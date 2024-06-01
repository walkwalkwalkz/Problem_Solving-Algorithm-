def GCD(a, b):
    mod = a%b
    while mod > 0:
        a = b
        b = mod
        mod = a%b
    return b


if __name__ == "__main__":
    for _ in range(int(input())):
        a, b = map(int, input().split())
        print(GCD(a=a, b=b))