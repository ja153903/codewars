def order(sentence):
    # we can split up the words
    # extracting the integers from the words
    # then placing them in a map

    d = {}

    for word in sentence.split(' '):
        for char in word:
            if char.isdigit():
                d[char] = word
                break

    return " ".join(d[key] for key in sorted(d.keys()))

def pythonic(sentence):
    return ' '.join(sorted(sentence.split(), key=lambda w: sorted(w)))

if __name__ == '__main__':
    print(order("is2 Thi1s T4est 3a"))


