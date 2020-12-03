import java.io.File

fun loader3(fileName: String): MutableList<MutableList<String>> {
    val returnList: MutableList<MutableList<String>> = mutableListOf()
    File(fileName).useLines { lines -> lines.forEach { returnList.add(it.split("").toMutableList()) }}
    returnList.map { it.removeLast()
                     it.removeFirst()}
    return returnList
}

fun treeCalc(mapList: MutableList<MutableList<String>>, right: Int, down: Int): Int {
    var i = 0
    var j = 0
    val maxLength = mapList.first().size

    var numTrees = 0

    while (i < mapList.size) {
        if (mapList[i][j % maxLength] == "#") {
            numTrees += 1
        }
        j += right
        i += down
    }

    return numTrees
}

fun prodCalc(mapList: MutableList<MutableList<String>>): Long {
    var result: Long = 1
    val slopeList: List<Pair<Int, Int>> = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))

    for (slope in slopeList) {
        result *= treeCalc(mapList, slope.first, slope.second)
    }

    return result
}