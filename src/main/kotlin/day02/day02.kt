import java.io.File

private fun getPair(input: List<String>): Pair<String,Int> = Pair(input.first(),input.last().toInt())
private fun readCommands(filePath:String):List<Pair<String,Int>> = File(filePath).readLines().map { getPair(it.split(" ")) }


fun main() {
    val instructions = readCommands(".\\src\\main\\kotlin\\day02\\input.txt")

    var x = 0
    var y = 0
    var aim=0

    instructions.forEach {
        when (it.first) {
            "forward" ->{
                x += it.second
                y += aim*it.second
            }
            "down" -> aim += it.second
            "up" -> aim -= it.second
        }
    }

    println("h-position=$x & depth=$y")
    println("result=${x*y}")

}