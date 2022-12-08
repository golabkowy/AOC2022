import java.io.File

fun main() {
    val txt = File("src/main/resources/day8.txt").readLines().map { it.map { it.toString().toInt() } }

    fun checkVisibility(x: Int, y: Int): Int {
        var left = true
        var right = true
        var top = true
        var bottom = true
        if (x == 0 || x == txt.size - 1 || y == 0 || y == txt.size - 1) {
            return 1
        }

        val horizontal = mutableListOf<Int>()
        val vertical = mutableListOf<Int>()
        for (i in y..y) {
            for (j in txt[y].indices) {
                vertical.add(txt[j][i])
            }
        }
        for (i in x..x) {
            for (j in txt[x].indices) {
                horizontal.add(txt[i][j])
            }
        }
        vertical.forEachIndexed { i, s ->
            if (i < x && s >= txt[x][y]) {
                top = false
            }
            if (i > x && s >= txt[x][y]) {
                bottom = false
            }
        }
        horizontal.forEachIndexed { i, s ->
            if (i < y && s >= txt[x][y]) {
                left = false
            }
            if (i > y && s >= txt[x][y]) {
                right = false
            }
        }
        return if (top || bottom || left || right) 1 else 0
    }

    var result = 0
    for (i in txt.indices) {
        for (j in txt[i].indices) {
            result += checkVisibility(i, j)
        }
    }

    println(result)

    // PART TWO
    var resultTWO = 0
    fun checkVisibilityB(x: Int, y: Int) {
        var horizontalLeft = mutableListOf<Int>()
        val horizontalRight = mutableListOf<Int>()
        var verticalUp = mutableListOf<Int>()
        val verticalDown = mutableListOf<Int>()

        for (i in txt.indices) {
            for (j in txt.indices) {
                if (i == x) {
                    if (j < y) {
                        horizontalLeft.add(txt[i][j])
                    }
                    if (j > y) {
                        horizontalRight.add(txt[i][j])
                    }
                }
                if (j == y) {
                    if (i < x) {
                        verticalUp.add(txt[i][j])
                    }
                    if (i > x) {
                        verticalDown.add(txt[i][j])
                    }

                }
            }

        }

        if (horizontalLeft.isNotEmpty()) horizontalLeft = horizontalLeft.reversed() as MutableList<Int>
        if (verticalUp.isNotEmpty()) verticalUp = verticalUp.reversed() as MutableList<Int>

        var lhs = 0
        var rhs = 0
        var uvs = 0
        var dvs = 0

        for (i in horizontalLeft.indices) {
            if (horizontalLeft[i] < txt[x][y]) {
                lhs++
            } else if (horizontalLeft[i] >= txt[x][y]) {
                lhs++
                break
            } else {
                break
            }
        }

        for (i in horizontalRight.indices) {
            if (horizontalRight[i] < txt[x][y]) {
                rhs++
            } else if (horizontalRight[i] >= txt[x][y]) {
                rhs++
                break
            } else {
                break
            }
        }

        for (i in verticalUp.indices) {
            if (verticalUp[i] < txt[x][y]) {
                uvs++
            } else if (verticalUp[i] >= txt[x][y]) {
                uvs++
                break
            } else {
                break
            }
        }

        for (i in verticalDown.indices) {
            if (verticalDown[i] < txt[x][y]) {
                dvs++
            } else if (verticalDown[i] >= txt[x][y]) {
                dvs++
                break
            } else {
                break
            }
        }


        val sumForTree = lhs * rhs * uvs * dvs
        if (sumForTree >= resultTWO) {
            resultTWO = sumForTree
        }
    }

    for (i in txt.indices) {
        for (j in txt[i].indices) {
            checkVisibilityB(i, j)
        }
    }

    checkVisibilityB(3, 2)
    print(resultTWO)
}