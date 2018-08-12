
fun predictAge(age1: Int, age2: Int, age3: Int, age4: Int, age5: Int, age6: Int, age7: Int, age8: Int): Int{

    return 0
}

fun predictAgeVar(vararg ages: Int) = (Math.sqrt(ages.map { it * it }.sum() * 1.0) / 2).toInt()


fun main(args: Array<String>) {
    println(predictAgeVar(65, 60, 75, 55, 60, 63, 64, 45))
}