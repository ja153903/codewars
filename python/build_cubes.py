def growing_cubes(m):
    prod = 0
    mult = 1
    while prod <= m:
        prod += mult**3
        yield mult, prod
        mult += 1

def find_nb(m):
    for mult, prod in growing_cubes(m):
        if prod == m:
            return mult

    return -1

if __name__ == '__main__':
    print(find_nb(4183059834009))
   # test.assert_equals(find_nb(24723578342962), -1)
   # test.assert_equals(find_nb(135440716410000), 4824)
   # test.assert_equals(find_nb(40539911473216), 3568)
   # test.assert_equals(find_nb(26825883955641), 3218)
