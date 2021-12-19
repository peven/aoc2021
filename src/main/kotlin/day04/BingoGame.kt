package day04

class BingoGame(inputLines: List<String>, val step: Int = 6) {
    val numbers = getRandomNumbers(inputLines)
    val boards = initBingoBoards(inputLines)

    private fun initBingoBoards(inputLines: List<String>) =
        inputLines.drop(1).windowed(step, step).map { BingoBoard.build(it) }

    private fun getRandomNumbers(inputLines: List<String>) = inputLines.first().split(",").map { it -> it.toInt() }

    fun play(strategy: STRATEGY): Int {
        var lastNumberPlayed = 0
        var lastWinningBingoBoard: BingoBoard? = null
        var lastWinningNumber = 0

        for (nb in numbers) {
            lastNumberPlayed = nb
            boards.forEach { board ->
                val bingoDetected = board.play(nb)
                if (bingoDetected) {
                    lastWinningBingoBoard = board
                    lastWinningNumber = lastNumberPlayed

                    if (strategy == STRATEGY.WIN) return board.score() * lastNumberPlayed
                }
            }
        }
        println(lastWinningBingoBoard)
        println(lastWinningNumber)

        return lastWinningBingoBoard?.score()?.times(lastWinningNumber) ?: 0
    }
}

