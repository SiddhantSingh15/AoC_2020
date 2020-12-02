val numList = loader1("1.txt")
val passList = loader2("2.txt")

fun main() {
    val year = 2020

    println("Day 1, part 1: " + calc2Prod(numList, year))
    timer1(numList, year, 10000)

    println("Day 1, part 2: " + calc3Prod(numList, year))
    timer2(numList, year, 10000)

    println("Day 2, part 1: " + validator(passList))
    timer3(passList, 10000)

    println("Day 2, part 2: " + validator2(passList))
    timer4(passList, 10000)

}