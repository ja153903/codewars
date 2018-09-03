package main

import "fmt"

func multipleOfIndex(ints []int) []int {
	result := []int{}
	for idx, value := range ints {
		if idx > 0 && value % idx == 0 {
			result = append(result, value)
		}
	}
	return result
}

func main() {
	fmt.Println(multipleOfIndex([]int{22, -6, 32, 82, 9, 25}))
}
