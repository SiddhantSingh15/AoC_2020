import java.io.File

fun loader2(fileName: String): MutableList<MutableList<Any>> {
    val returnList: MutableList<MutableList<Any>> = mutableListOf()
    File(fileName).useLines { lines -> lines.forEach { returnList.add(converter(it)) }}
    returnList.map { it.toList() }

    return returnList
}

private fun converter(string: String): MutableList<Any> {
    val finalList: MutableList<Any> = string.split(":", "-", " ").toMutableList()
    val newList = remove(finalList, 3)
    newList[0] = newList[0].toString().toInt()
    newList[1] = newList[1].toString().toInt()
    newList[2] = newList[2].toString().first()
    return  newList
}

private fun remove(arr: MutableList<Any>, index: Int): MutableList<Any> {
    return if (index < 0 || index >= arr.size) {
        arr
    } else (arr.indices)
        .filter { i: Int -> i != index }
        .map { i: Int -> arr[i] }
        .toMutableList()
}

private fun checker(smallList: MutableList<Any>): Boolean {
    val min: Int = smallList[0] as Int
    val max: Int = smallList[1] as Int
    val char: Char = smallList[2] as Char
    val pass: String = smallList[3] as String
    val counter: Int = pass.filter { it == char }.count()
    return (min <= counter) && (counter <= max)
}

private fun checker2(smallList: MutableList<Any>): Boolean {
    val iPos: Int = smallList[0] as Int
    val fPos: Int = smallList[1] as Int
    val char: Char = smallList[2] as Char
    val pass: String = smallList[3] as String
    return (pass[iPos - 1] == char) && (pass[fPos - 1] != char) || (pass[iPos - 1] != char) && (pass[fPos - 1] == char)
}

fun validator(fullList: MutableList<MutableList<Any>>): Int {
    val finalList: List<Boolean> = fullList.map { checker(it) }
    return finalList.count { it }
}

fun validator2(fullList: MutableList<MutableList<Any>>): Int {
    val finalList: List<Boolean> = fullList.map { checker2(it) }
    return finalList.count { it }
}
