import java.io.File

fun main() {
    // PART ONE
    print(
        File("src/main/resources/day4.txt").readLines()
            .map {
                it.split(",")
                    .map {
                        val s = it.split("-")
                        Pair(s[0].toInt(), s[1].toInt())
                    }
            }
            .filter {
                (it[0].first..it[0].second).contains(it[1].first) && (it[0].first..it[0].second).contains(it[1].second) ||
                        (it[1].first..it[1].second).contains(it[0].first) && (it[1].first..it[1].second).contains(it[0].second)
                // PART TWO - just different condition on filtering

                /**      .filter {
                (it[0].first..it[0].second).contains(it[1].first) || (it[0].first..it[0].second).contains(it[1].second) ||
                (it[1].first..it[1].second).contains(it[0].first) || (it[1].first..it[1].second).contains(it[0].second)
                }
                 */
            }.count()
    )
}