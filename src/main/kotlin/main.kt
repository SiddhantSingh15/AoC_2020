import java.util.*
import kotlin.system.measureNanoTime

fun timer1(nList: TreeSet<Int>, sum: Int, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { calc2Prod(nList, sum) }).toDouble() / 1000
    }
    val average: Double = (timeList / runs)
    println("Average time taken for $runs runs: $average nanoseconds")
}

fun timer2(nList: TreeSet<Int>, sum: Int, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { calc3Prod(nList, sum) }).toDouble() / 1000
    }
    val average: Double = timeList / runs
    println("Average time taken for $runs runs: $average nanoseconds")
}


fun main() {
    val numList = loader("1.txt")

    val year = 2020

    println(calc2Prod(numList, year))
    timer1(numList, year, 10000)

    println(calc3Prod(numList, year))
    timer2(numList, year, 10000)

}