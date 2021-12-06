import java.io.File

private fun getPair(input: List<String>): Pair<String,Int> = Pair(input.first(),input.last().toInt())
private fun readCommands(filePath:String):List<Pair<String,Int>> = File(filePath).readLines().map { getPair(it.split(" ")) }

enum class Operation { FORWARD, UP, DOWN }
data class Command(val operation:Operation, val value:Int)
data class Position(val distance: Int=0, val depth: Int=0, val aim: Int=0) {

    private fun forward(moveBy:Int):Position{
        return Position(distance+moveBy, depth+aim*moveBy, aim)
    }

    private fun down(moveBy:Int):Position {
        return Position(distance, depth, aim+moveBy)
    }

    private fun up(moveBy:Int):Position {
        return Position(distance, depth, aim-moveBy)
    }

    fun move(command:Command): Position = when (command.operation) {
        Operation.FORWARD -> forward(command.value)
        Operation.DOWN -> down(command.value)
        Operation.UP -> up(command.value)
    }
}


fun main() {
    val instructions = readCommands(".\\src\\main\\kotlin\\day02\\input.txt").map { Command(Operation.valueOf(it.first.uppercase()), it.second)}
    var finalPosition = instructions.fold(Position()) { acc, command -> acc.move(command) }

    println("distance=${finalPosition.distance} & depth=${finalPosition.depth}")
    println("result=${finalPosition.distance*finalPosition.depth}")
}
