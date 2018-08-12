import java.util.function.LongBinaryOperator
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun gcdi(xx:Long, yy:Long):Long {
    return abs(xx * yy) / lcmu(xx, yy)
}

fun lcmu(a:Long, b:Long): Long {
    val maxNum = maxi(a, b)
    val itrEnd = ((a * b) / maxNum).toLong()
    var i = 1
    var j = 1
    while (i <= itrEnd && j <= itrEnd) {
        if (a * i == b * j) {
            return a * i
        } else if (a * i < b * j) {
            i++
        } else {
            j++
        }
    }
    return a * b
}

fun sum(a:Long, b:Long) = a + b

fun maxi(a:Long, b:Long) = max(a, b)

fun mini(a:Long, b:Long) = min(a, b)

fun operArray(f: LongBinaryOperator, arr:LongArray, init:Long):LongArray {
    // your code and complete the "..." with your generic function

    arr.fold(init) { acc, el -> f.applyAsLong(acc, el) }

    return longArrayOf()
}

fun main(args: Array<String>) {
    val a = longArrayOf(18, 69, -90, -78, 65, 40)
//    val res = operArray(LongBinaryOperator({ a, b -> sum(a, b) }), a, 0)
//    res.forEach { println(it) }

    operArray(LongBinaryOperator({ a, b -> maxi(a, b)}), a, a[0])
}