import java.io.File
import java.util.*

fun loader7(fileName: String): TreeSet<String> {
    val numList: TreeSet<String> = TreeSet()
    File(fileName).useLines { lines -> lines.forEach { numList.add(it) }}
    return numList
}

const val bagName = "shiny gold"
fun gold1(lines: TreeSet<String>): Int {
    return lines
        .map { Regex("(?<=(\\d )|^)[a-z]+ [a-z]+(?= bag)").findAllToList(it) }
        .map { s -> s.subList(1, s.size).map { Pair(s[0], it) } }
        .flatten()
        .groupBy { it.second }
        .mapValues { entry -> entry.value.map { it.first }.toSet() }
        .withDefault { setOf() }
        .countBags(bagName)
        .size - 1
}

fun gold2(lines: TreeSet<String>): Int {
    return lines
        .map { Regex("(?<=(\\d )|^)[a-z]+ [a-z]+(?= bag)|\\d").findAllToList(it) }
        .associate {
            it[0] to it.subList(1, it.size)
                .chunked(2) { s -> Pair(s[1], s[0].toInt()) }
        }
        .withDefault { listOf() }
        .sumBags(bagName, 1) - 1
}

private fun Regex.findAllToList(line: String): List<String> =
    this.findAll(line).map { matchResult -> matchResult.value }.toList()

private fun Map<String, Set<String>>.countBags(bag: String): Set<String> =
    this.getValue(bag)
        .flatMapTo(HashSet()) { this.countBags(it) }
        .plus(bag)

private fun Map<String, List<Pair<String, Int>>>.sumBags(bag: String, multiplier: Int): Int =
    this.getValue(bag)
        .sumBy { this.sumBags(it.first, it.second * multiplier) }
        .plus(multiplier)