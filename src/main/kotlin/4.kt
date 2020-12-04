import java.io.File
import java.lang.Math.abs
import java.lang.Math.log10
import kotlin.text.Regex


fun loader4(fileName: String): List<Map<String, String>> {
    val stringMaker = File(fileName).readText().split("\n\n")
    return stringMaker.map { it ->
        it.split(" ", "\n").associate {
        val (key, pair) = it.split(":")
        key to pair
    } }
}

fun validator(passportList: List<Map<String, String>>): Int {
    return passportList.count { p -> p.size == 8 || p.size == 7 && "cid" !in p.keys }
}

fun validator2(passportList: List<Map<String, String>>): Int {
    val rules = mapOf<String, (String) -> Boolean>(
        "byr" to { it.toInt() in 1920..2002 },
        "iyr" to { it.toInt() in 2010..2020 },
        "eyr" to { it.toInt() in 2020..2030 },
        "hgt" to {
            Regex("([0-9]+)(cm|in)").matchEntire(it)?.let { m ->
                when (m.groupValues[2]) {
                    "cm" -> m.groupValues[1].toInt() in 150..193
                    "in" -> m.groupValues[1].toInt() in 59..76
                    else -> false
                }
            } ?: false
        },
        "hcl" to { Regex("#[0-9a-f]{6}").matches(it) },
        "ecl" to { it in setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth") },
        "pid" to { Regex("[0-9]{9}").matches(it) },
    )
    return passportList.count { p -> rules.all { it.value(p[it.key] ?: "0") } }
}