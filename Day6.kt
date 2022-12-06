import java.io.File

fun main() {
    // PART ONE AND TWO, just change pattern size
    val patternSize: Int = 14
    val txt = File("src/main/resources/day6.txt").readText()

    for (i in patternSize..txt.length) {
        val str: String = txt.substring(i - patternSize until i)
        var counter = 0
        for (j: Char in str) {
            for (k: Char in str) {
                if (j != k) {
                    counter++
                }
            }
        }
        if (counter == patternSize*(patternSize-1)) {
            println(i)
            return
        }
    }

}