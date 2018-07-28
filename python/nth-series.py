def series_sum(n):
    def generate_sequence():
        i = 1
        for _ in range(0, n):
            yield i
            i = i + 3.0
    return "{0:.2f}".format(sum(1.0 / val for val in generate_sequence()))

if __name__ == '__main__':
    print(series_sum(3))
