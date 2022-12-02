import java.io.File

fun main() {
    fun matchResult(pair: Pair<Char, Char>): Int {
        // draw == 3, loose = 0, win == 6
        // kamien, papier, nozyce
        return when (pair) {
            Pair('A', 'X') -> 4
            Pair('A', 'Y') -> 8
            Pair('A', 'Z') -> 3

            Pair('B', 'X') -> 1
            Pair('B', 'Y') -> 5
            Pair('B', 'Z') -> 9

            Pair('C', 'X') -> 7
            Pair('C', 'Y') -> 2
            Pair('C', 'Z') -> 6
            else -> {
                0
            }
        }
    }

    fun matchResultPart2(pair: Pair<Char, Char>): Int {
        // x - loose, y - draw, z - win
        // kamien, papier, nozyce
        return when (pair) {
            Pair('A', 'X') -> 3
            Pair('A', 'Y') -> 4
            Pair('A', 'Z') -> 8

            Pair('B', 'X') -> 1
            Pair('B', 'Y') -> 5
            Pair('B', 'Z') -> 9

            Pair('C', 'X') -> 2
            Pair('C', 'Y') -> 6
            Pair('C', 'Z') -> 7
            else -> {
                0
            }
        }
    }
    var result = 0
    var result2 = 0
    File("src/main/resources/day2.txt").forEachLine {
       result+= matchResult(Pair(it[0], it[2]))
       result2+= matchResultPart2(Pair(it[0], it[2]))
    }
    println(result)
    println(result2)
}
