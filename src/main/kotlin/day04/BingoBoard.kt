package day04

data class BingoBoard(val matrix:List<List<Int>>) {
    val boardSize = matrix.first().count()
    var boardResult = BoardResult(boardSize)

    fun find(number: Int): Coord? {
        matrix.forEachIndexed { rowIndex, row -> row.forEachIndexed { colIndex, cell -> if (cell==number) return Coord(rowIndex,colIndex) } }
        return null
    }

    fun score(): Int {
        var result = 0

        matrix.forEachIndexed { rowIndex, columns ->
            columns.forEachIndexed{ colIndex, cell ->
                if (!boardResult.coordinates.contains(Coord(rowIndex, colIndex)))
                    result += matrix[rowIndex][colIndex]
            }
        }

        return result
    }

    fun play(number: Int): Boolean {
        val coord = find(number)
        return if (coord is Coord) {
            boardResult.append(coord)
            return boardResult.isBingo()
        } else
            false
    }

    companion object {
        fun build(stringInput: List<String>): BingoBoard {
                var matrix = stringInput.filter { row -> !row.isNullOrBlank() }
                    .map{ row -> row.chunked(3) { t -> t.trim().toString().toInt() }
            }
            return BingoBoard(matrix)
        }
    }
}
