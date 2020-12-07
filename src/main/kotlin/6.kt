import com.sun.source.tree.Tree
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

fun loader6(fileName: String): List<String> {
    val stringMaker = File(fileName).readText().split("\n\n")
    return stringMaker
}

fun part1(customList: List<String>): Int {
    return customList
        .map { it.replace("\n", "") }
        .map { it -> it.groupBy { it }.size }.sum()
}

fun part2(customList: List<String>): Int {
    return customList.map { its ->
        its.replace("\n", "")
            .groupBy { it }
            .filter { it.value.size == its.split("\n").size }
            .size
    }.sum()
}