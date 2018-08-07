from math import sqrt

#def is_prime(integer):
#    if integer <= 1: return False
#    if integer == 2: return True
#    if integer % 2 == 0: return False
#
#    for n in range(3, int(sqrt(integer))+1):
#        if integer % n == 0: return False
#    return True

def divisors(integer):
    res = [divisor for divisor in range(2, integer)
            if integer % divisor == 0]
    return res if len(res)> 0 else "{} is prime".format(integer)

if __name__ == '__main__':
    print(divisors(12))
    print(divisors(25))
    print(divisors(13))
