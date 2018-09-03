package main

func Maps(x []int) []int {
	result := make([]int, len(x))

	for idx, value := range x {
		result[idx] = value * 2
	}

	return result 
}
