import java.io.File

private fun readInput(filePath:String):List<String> = File(filePath).readLines()

fun main() {
    val instructions = readCommands(".\\src\\main\\kotlin\\day03\\input.txt")
}