package day04

class BingoGame(inputLines: List<String>, val step: Int=6) {
    val numbers = getRandomNumbers(inputLines)
    val boards = initBingoBoards(inputLines)

    private fun initBingoBoards(inputLines: List<String>) =
        inputLines.drop(1).windowed(step, step).map { BingoBoard.build(it) }

    private fun getRandomNumbers(inputLines: List<String>) = inputLines.first().split(",")
}
