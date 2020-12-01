import java.io.File
import java.io.BufferedReader

fun loader(fileName: String): List<Int> {
    val numList = mutableListOf<Int>()
    File(fileName).useLines { lines -> lines.forEach { numList.add(it.toInt()) }}
    return numList
}

fun calc2Prod(lineList: List<Int>, sum: Int): Int {
    val done: MutableSet<Int> = mutableSetOf()
    for (num in lineList) {
        val second: Int = sum - num
        if (done.contains(second)) {
            return num*second
        } else {
            done.add(num)
        }
    }
    return 0
}

fun calc3Prod(lineList: List<Int>, sum: Int): Int {
    lineList.sorted()
    for (i in lineList) {
        for (j in lineList) {
            if (lineList.contains(sum - i - j)) {
                return i * j * (sum - i - j)
            }
        }
    }
    return 0
}