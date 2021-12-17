package day04

class BingoGame(inputLines: List<String>, val step: Int=6) {
    val numbers = getRandomNumbers(inputLines)
    val boards = initBingoBoards(inputLines)

    private fun initBingoBoards(inputLines: List<String>) =
        inputLines.drop(1).windowed(step, step).map { BingoBoard.build(it) }

    private fun getRandomNumbers(inputLines: List<String>) = inputLines.first().split(",").map { it -> it.toInt() }

    fun play(): Int {
        var lastNumberPlayed = 0
        for (nb in numbers) {
            lastNumberPlayed = nb
            boards.forEach { board ->
                if (board.play(nb))
                {
                    return board.score()*lastNumberPlayed
                }
            }
        }
        return 0
    }
}

