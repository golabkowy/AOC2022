import java.io.File

fun main() {

    class Directory(val up: Directory? = null) {
        val subDirectories = HashMap<String, Directory>()
        var filesSize = 0L
        var directorySize = 0L
    }

    val root = Directory()
    var currentDirectory = root

    File("src/main/resources/day7.txt").readLines().forEach {
        when {
            it.startsWith("$ cd ") -> {
                currentDirectory = when (it.substringAfter("$ cd ").trim()) {
                    "/" -> root
                    ".." -> currentDirectory.up!!
                    else -> currentDirectory.subDirectories.getOrPut(it.substringAfter("$ cd ").trim()) {
                        Directory(currentDirectory)
                    }
                }
            }
            it.startsWith("$ ls") -> {
            }
            else -> {
                val (str, name) = it.split(" ")
                if (str == "dir") {
                    currentDirectory.subDirectories.getOrPut(name) { Directory(currentDirectory) }
                } else {
                    currentDirectory.filesSize += str.toLong()
                }
            }
        }
    }

    var result = 0L
    fun traverse(currentDirectory: Directory): Long {
        currentDirectory.subDirectories.forEach { currentDirectory.directorySize += traverse(it.value) }
        currentDirectory.directorySize += currentDirectory.filesSize
        if (currentDirectory.directorySize <= 100000) result += currentDirectory.directorySize
        return currentDirectory.directorySize
    }

    traverse(root)
    println(result)

}