import java.io.File

fun main() {
    var maxTemp = 0
    var max = 0
    val matrix = sortedSetOf<Int>()
    File("src/main/resources/day1.txt").forEachLine {
        it.toIntOrNull().also { num ->
            maxTemp += num ?: 0
        }.also { el ->
            if (el == null) {
                matrix.add(maxTemp)
                if (maxTemp >= max) {
                    max = maxTemp
                    maxTemp = 0

                }else{
                    maxTemp=0
                }
            }
        }
    }

    println(max)
    println(matrix.pollLast()?.let { matrix.pollLast()?.plus(it)?.let { matrix.pollLast()?.plus(it) } })
}
`