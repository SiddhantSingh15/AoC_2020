import java.io.File
import java.util.*

fun loader1(fileName: String): TreeSet<Int> {
    val numList: TreeSet<Int> = TreeSet()
    File(fileName).useLines { lines -> lines.forEach { numList.add(it.toInt()) }}
    return numList
}

fun calc2Prod(lineList: TreeSet<Int>, sum: Int): Int {
    for (num in lineList) {
        if (lineList.contains(sum - num)) {
            return (num * (sum - num))
        }
    }
    return 0
}

fun calc3Prod(lineList: TreeSet<Int>, sum: Int): Int {
    for (i in lineList) {
        for (j in lineList) {
            if (lineList.contains(sum - i - j)) {
                return i * j * (sum - i - j)
            }
        }
    }
    return 0
}