def is_prime(integer):
    if integer <= 1: return False
    if integer == 2: return True
    if integer % 2 == 0: return False

    for n in range(3, int(sqrt(integer))+1):
        if integer % n == 0: return False
    return True

