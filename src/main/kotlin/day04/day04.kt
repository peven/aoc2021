import day04.BingoGame
import day04.STRATEGY
import java.io.File

private fun readCommands(filePath:String):List<String> = File(filePath).readLines()

fun main() {
    val inputLines = readCommands(".\\src\\main\\kotlin\\day04\\input.txt")

    val bingoGame1 = BingoGame(inputLines)
    val resultOfWinningStrategy = bingoGame1.play(STRATEGY.WIN)

    println("Result of Part #1 is $resultOfWinningStrategy")

    val bingoGame2 = BingoGame(inputLines)
    val resultOfLosingStrategy = bingoGame2.play(STRATEGY.LOSE)

    println("Result of Part #2 is $resultOfLosingStrategy")
}

