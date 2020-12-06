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

fun timer5(mapList:  MutableList<MutableList<String>>, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { treeCalc(mapList, 3, 1) }).toDouble() / 1000
    }
    val average: Double = timeList / runs
    println("  - Average time taken for $runs runs: $average µs")
}

fun timer6(mapList:  MutableList<MutableList<String>>, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { prodCalc(mapList) }).toDouble() / 1000
    }
    val average: Double = timeList / runs
    println("  - Average time taken for $runs runs: $average µs")
}

fun timer7(passList:  List<Map<String, String>>, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { validator(passList) }).toDouble() / 1000
    }
    val average: Double = timeList / runs
    println("  - Average time taken for $runs runs: $average µs")
}

fun timer8(passList:  List<Map<String, String>>, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { validator2(passList) }).toDouble() / 1000
    }
    val average: Double = timeList / runs
    println("  - Average time taken for $runs runs: $average µs")
}

fun timer9(boardList:  IntArray, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { part1(boardList) }).toDouble() / 1000
    }
    val average: Double = timeList / runs
    println("  - Average time taken for $runs runs: $average µs")
}

fun timer10(boardList:  IntArray, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { part2(boardList) }).toDouble() / 1000
    }
    val average: Double = timeList / runs
    println("  - Average time taken for $runs runs: $average µs")
}

fun timer11(customList:  List<String>, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { part1(customList) }).toDouble() / 1000
    }
    val average: Double = timeList / runs
    println("  - Average time taken for $runs runs: $average µs")
}

fun timer12(customList:  List<String>, runs: Int) {
    var timeList = 0.0
    for (i in 1..runs) {
        timeList += (measureNanoTime { part2(customList) }).toDouble() / 1000
    }
    val average: Double = timeList / runs
    println("  - Average time taken for $runs runs: $average µs")
}