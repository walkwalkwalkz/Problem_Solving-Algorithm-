for _ in range(int(input())):
    tmp = input()
    if tmp[len(tmp)//2]==tmp[len(tmp)//2-1]:
        print("Do-it")
    else:
        print("Do-it-Not")