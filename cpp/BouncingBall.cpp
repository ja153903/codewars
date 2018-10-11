#include <bits/stdc++.h>

class BouncingBall {
public:
    static int bouncingBall(double h, double bounce, double window) {
        if (h < 0 || bounce < 0 || bounce >= 1 || window >= h) { return -1; }

        int seen = 0;
        
        while (h > window) {
            seen++;
            if ((h *= bounce) > window) {
                seen++;
            }
        }

        return seen;
    }
};

int main() {
    std::cout << BouncingBall::bouncingBall(3, 0.66, 1.5) << std::endl;
    return 0;
}