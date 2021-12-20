package day04

class BingoGame(inputLines: List<String>, val step: Int = 6) {
    val draws = getRandomNumbers(inputLines)
    val boards = initBingoBoards(inputLines)

    private fun initBingoBoards(inputLines: List<String>) =
        inputLines.drop(1).windowed(step, step).map { BingoBoard.build(it) }

    private fun getRandomNumbers(inputLines: List<String>) = inputLines.first().split(",").map { it -> it.toInt() }

    fun play(strategy: STRATEGY): Int {
        var lastNumberPlayed: Int
        var lastWinningBingoBoard: BingoBoard? = null
        var lastWinningNumber = 0

        for (number in draws) {
            lastNumberPlayed = number
            boards.forEach { board ->
                if (board.isBingo) {
                    return@forEach
                }
                val bingoDetected = board.play(number)
                if (bingoDetected) {
                    board.isBingo= true
                    lastWinningBingoBoard = board
                    lastWinningNumber = lastNumberPlayed

                    if (strategy == STRATEGY.WIN) return board.score() * lastNumberPlayed
                }
            }
        }
        return lastWinningBingoBoard?.score()?.times(lastWinningNumber) ?: 0
    }
}

