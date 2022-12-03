import java.io.File

fun main() {
    // PART ONE
    var result = 0
    fun String.filterOutString(str: String): Char = this.filter { str.contains(it, false) }[0]
    fun itemPriority(char: Char): Int =
        when (char.isUpperCase()) {
            false -> char.toInt() - 96
            true -> char.toInt() - 38
        }
    File("src/main/resources/day3.txt").forEachLine {
        itemPriority(
            it.slice(0 until it.length / 2).filterOutString(it.slice(it.length / 2 until it.length))
        ).let { result += it }
    }
    println(result)

    // PART TWO
    val txt: List<String> = File("src/main/resources/day3.txt").readText().split('\n')

    fun String.findBadge(vararg strArr: String): Char {
        var t = this
        for (element in strArr)
            t = t.filter { element.contains(it, false) }
        return t[0]
    }

    var list = mutableListOf<Char>()
    for (i in txt.indices step 3) {
        list.add(txt[i].findBadge(txt[i + 1], txt[i + 2]))
    }
    val result2 = list.map { itemPriority(it) }.sum()
    println(result2)
}