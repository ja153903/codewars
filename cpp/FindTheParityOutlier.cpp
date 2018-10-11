#include <bits/stdc++.h>

int findOutlier(std::vector<int> arr) {
    int odd = 0, even = 0;

    for (int i = 0; i < 3; i++) {
        if (arr[i] % 2 == 0) even++;
        if (arr[i] % 2 == 1) odd++;
    }

    bool isEven = false;

    if (even > odd) {
        isEven = !isEven;
    }

    for (int n: arr) {
        if (isEven && std::abs(n) % 2 == 1) {
            return n;
        } 

        if (!isEven && std::abs(n) % 2 == 0) {
            return n;
        }
    }

    return -1;
}

int cleverSolution(std::vector<int> arr) {
    int even, odd;
    int evenCount = 0, oddCount = 0;

    for (auto a: arr) {
        a % 2 == 0 ? (evenCount++, even = a) : (oddCount++, odd = a);
    }

    return evenCount < oddCount ? even : odd;
}

int main() {
    std::vector<int> t1{2,3,4};
    std::cout << findOutlier(t1) << std::endl;

    std::vector<int> t2{4, 1, 3, 5, 9};
    std::cout << findOutlier(t2) << std::endl;

    std::vector<int> t3{2, -6, 8, -10, -3};
    std::cout << findOutlier(t3) << std::endl;

    return 0;
}