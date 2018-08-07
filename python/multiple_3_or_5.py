def solution(x):
    return sum(i for i in range(1, x)
               if i % 3 == 0 or i % 5 == 0)

if __name__ == '__main__':
    print(solution(10))
