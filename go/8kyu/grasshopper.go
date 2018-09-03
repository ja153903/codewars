package main

import "fmt"

func combat(health, damage float64) float64 {
	if health -= damage; health < 0 {
		return 0.0
	} 
	return health 
}

func main() {
	fmt.Println(combat(100, 50.0))
}
