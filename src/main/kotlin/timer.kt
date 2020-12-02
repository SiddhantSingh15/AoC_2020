import java.util.*
import kotlin.system.measureNanoTime

fun timer1(nList: TreeSet<Int>, sum: Int, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { calc2Prod(nList, sum) }).toDouble() / 1000
    }
    val average: Double = (timeList / runs)
    println("  - Average time taken for $runs runs: $average µs")
}

fun timer2(nList: TreeSet<Int>, sum: Int, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { calc3Prod(nList, sum) }).toDouble() / 1000
    }
    val average: Double = timeList / runs
    println("  - Average time taken for $runs runs: $average µs")
}

fun timer3(nList: MutableList<MutableList<Any>>, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { validator(nList) }).toDouble() / 1000
    }
    val average: Double = timeList / runs
    println("  - Average time taken for $runs runs: $average µs")
}

fun timer4(nList: MutableList<MutableList<Any>>, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { validator2(nList) }).toDouble() / 1000
    }
    val average: Double = timeList / runs
    println("  - Average time taken for $runs runs: $average µs")
}