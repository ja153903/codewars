package main

import (
	"fmt"
)

// This is a way we can simulate using Python generators 
func fibonacciGenerator(n int) <-chan int {
	c := make(chan int)
	fib, prev := 2, 1
	
	go func() {
		defer close(c)
		for fib <= n {
			if fib % 2 == 0 {
				c <- fib 
			}
			fib, prev = fib + prev, fib
		}
	}()

	return c
}

func main() {
	sum := 0
	for x := range fibonacciGenerator(111111) {
		sum += x
	} 
	fmt.Println(sum)
}
