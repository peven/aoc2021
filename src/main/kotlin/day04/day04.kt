import java.io.File

private fun readCommands(filePath:String):List<String> = File(filePath).readLines()

fun main() {
    val instructions = readCommands(".\\src\\main\\kotlin\\day04\\input.txt")
}