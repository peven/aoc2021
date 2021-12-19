import day04.BingoGame
import day04.STRATEGY
import java.io.File

private fun readCommands(filePath:String):List<String> = File(filePath).readLines()

fun main() {
    val inputLines = readCommands(".\\src\\main\\kotlin\\day04\\input.txt")

    val bingoGame: BingoGame = BingoGame(inputLines)

    val result = bingoGame.play(STRATEGY.WIN)

    println("Result of Part #1 is $result")

}

