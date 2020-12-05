import com.sun.source.tree.Tree
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

fun loader5(fileName: String): IntArray {
    val returnList: ArrayList<Int> = arrayListOf()
    File(fileName).useLines { lines -> lines.forEach { returnList.add(seatCalc(it)) }}
    return returnList.sorted().toIntArray()
}

private fun seatCalc(string: String): Int {
    return string.replace('B', '1').replace('R', '1').replace('F', '0').replace('L', '0').toInt(2)
}

fun part1(list: IntArray): Int {
    return list.last()
}

fun part2(input: IntArray): Int {
    input.forEach {
        if (!input.contains(it + 1)) {
            return (it + 1)
        }
    }
    return 0
}