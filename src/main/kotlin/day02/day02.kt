import java.io.File

private fun getPair(input: List<String>): Pair<String,Int> = Pair(input.first(),input.last().toInt())

private fun readCommands(filePath:String):List<Pair<String,Int>> = File(filePath).readLines().map { getPair(it.split(" ")) }


fun main() {
    val instructions = readCommands(".\\src\\main\\kotlin\\day02\\input.txt")

    var distance = 0
    var depth = 0

    instructions.forEach {
        when (it.first) {
            "forward" -> distance += it.second
            "down" -> depth += it.second
            "up" -> depth -= it.second
        }
    }

    println("distance=$distance & depth=$depth")
    println("result=${distance*depth}")

}