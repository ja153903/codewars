#include <bits/stdc++.h>

std::vector<int> tribonacci(std::vector<int> signature, int n) {

    if (n < signature.size()) {
        signature.resize(n);
    }

    for (int i = 3; i < n; i++) {
        signature.push_back(signature[i-1] + signature[i-2] + signature[i-3]);
    }

    return signature;
}

