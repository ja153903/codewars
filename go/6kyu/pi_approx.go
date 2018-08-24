package main

import (
	"fmt"
	"math"
)

func IterPi(epsilon float64) (int, string) {
	approx := 1.0
	count := 1
	denom := 3

	for math.Abs(4 * approx - math.Pi) >= epsilon {
		if count % 2 != 0 {
			// if even number then subtract
			approx -= 1.0 / float64(denom) 
		} else {
			approx += 1.0 / float64(denom) 
		}

		denom += 2
		count++
	}

	return count, fmt.Sprintf("%.10f", approx*4)
}

func main() {
	num, str := IterPi(0)
	fmt.Println(num, str)
}
