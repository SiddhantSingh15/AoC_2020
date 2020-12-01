import kotlin.system.measureNanoTime

fun timer1(nList: List<Int>, sum: Int, runs: Int) {
    val timeList: MutableList<Long> = mutableListOf()
    for (i in 1..runs) {
        timeList.add(measureNanoTime { calc2Prod(nList, sum) })
    }
    val average: Double = timeList.map { it / 1000 }.average()
    println("Average time taken for $runs runs: $average µs")
}

fun timer2(nList: List<Int>, sum: Int, runs: Int) {
    val timeList: MutableList<Long> = mutableListOf()
    for (i in 1..runs) {
        timeList.add(measureNanoTime { calc3Prod(nList, sum) })
    }
    val average: Double = timeList.map { it / 1000 }.average()
    println("Average time taken for $runs runs: $average µs")
}


fun main() {
    val numList = loader("1.txt")

    val year = 2020

    println(calc2Prod(numList, year))
    timer1(numList, year, 100)

    println(calc3Prod(numList, year))
    timer2(numList, year, 100)

}