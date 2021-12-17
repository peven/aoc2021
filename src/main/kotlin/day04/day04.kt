import day04.BingoBoard
import day04.BingoGame
import java.io.File

private fun readCommands(filePath:String):List<String> = File(filePath).readLines()

fun main() {
    val inputLines = readCommands(".\\src\\main\\kotlin\\day04\\input.txt")

    val bingoGame: BingoGame = BingoGame(inputLines)



}

