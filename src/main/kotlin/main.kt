fun main() {
    val numList = (loader("1.txt")).sorted()

    val year = 2020
    println(calc2Prod(numList, year))
    println(calc3Prod(numList, year))

}