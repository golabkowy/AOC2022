import java.io.File

fun main() {
    val cargoCrane = mutableListOf(
        mutableListOf(),
        mutableListOf('B', 'Q', 'C'),
        mutableListOf('R', 'Q', 'W', 'Z'),
        mutableListOf('B', 'M', 'R', 'L', 'V'),
        mutableListOf('C', 'Z', 'H', 'V', 'T', 'W'),
        mutableListOf('D', 'Z', 'H', 'B', 'N', 'V', 'G'),
        mutableListOf('H', 'N', 'P', 'C', 'J', 'F', 'V', 'Q'),
        mutableListOf('D', 'G', 'T', 'R', 'W', 'Z', 'S'),
        mutableListOf('C', 'G', 'M', 'N', 'B', 'W', 'Z', 'P'),
        mutableListOf('N', 'J', 'B', 'M', 'W', 'Q', 'F', 'P'),
    )

    fun replaceCrate(amount: Int, from: Int, to: Int) {
        /** PART TWO:
        cargoCrane[to].addAll(cargoCrane[from].subList(cargoCrane[from].size - amount, cargoCrane[from].size)
         */
        cargoCrane[to].addAll(
            cargoCrane[from].subList(cargoCrane[from].size - amount, cargoCrane[from].size).reversed()
        )
        cargoCrane[from] = cargoCrane[from].dropLast(amount).toMutableList()
    }

    File("src/main/resources/day5.txt").readLines()
        .forEach { replaceCrate(it.split(" ")[1].toInt(), it.split(" ")[3].toInt(), it.split(" ")[5].toInt()) }

}

