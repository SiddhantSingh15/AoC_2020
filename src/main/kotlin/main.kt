import java.util.*
import kotlin.collections.HashSet
import kotlin.system.measureNanoTime

fun timer1(nList: TreeSet<Int>, sum: Int, runs: Int) {
    var timeList: Long = 0
    for (i in 1..runs) {
        timeList += (measureNanoTime { calc2Prod(nList, sum) }) / 1000
    }
    val average: Long = timeList / runs
    println("Average time taken for $runs runs: $average µs")
}

fun timer2(nList: TreeSet<Int>, sum: Int, runs: Int) {
    var timeList: Long = 0
    for (i in 1..runs) {
        timeList += (measureNanoTime { calc3Prod(nList, sum) }) / 1000
    }
    val average: Long = timeList / runs
    println("Average time taken for $runs runs: $average µs")
}


fun main() {
    val numList = loader("1.txt")

    val year = 2020

    println(calc2Prod(numList, year))
    timer1(numList, year, 1000000)

    println(calc3Prod(numList, year))
    timer2(numList, year, 1000000)

}