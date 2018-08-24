package main

import (
	"fmt"
	"strings"
)

func duplicate_count(s1 string) int {
	
	dup_count := 0

	counter := map[rune]int{}

	for _, r := range strings.ToLower(s1) {
		if counter[r]++; counter[r] == 2 {
			dup_count++
		}
	}


	return dup_count 
}

func main() {
	fmt.Println(duplicate_count("abcde"))
	fmt.Println(duplicate_count("abcdea"))
	fmt.Println(duplicate_count("aabbcde"))
	fmt.Println(duplicate_count("abcdeaB11"))
	fmt.Println(duplicate_count("indivisibility"))
}
