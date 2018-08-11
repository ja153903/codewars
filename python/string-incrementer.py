def increment_string(strng):
    # find the first index of a digit
    # then get substring till the end
    # increment the substring (integer) by 1
    # then fill 0s into new integer
    if not strng[len(strng)-1].isdigit(): return "1"

    index = -1
    for i in range(len(strng)):
        if strng[i].isdigit():
            index = i
            break

    if index == -1:
        return "{}1".format(strng)

    # length of goal string
    n = len(strng) - index
    int_val = int(strng[index:])+1
    str_val = str(int_val)
    num_zeros = n - len(str_val)

    s ="".join(["0" for _ in range(num_zeros)])
    return "{}{}{}".format(strng[:index], s, int_val)

print(increment_string('foo'))
print(increment_string('foobar23'))
