package day04

data class BingoBoard(val matrix:List<List<Int>>) {
    companion object {
        fun build(stringInput: List<String>): BingoBoard {
                var matrix = stringInput.filter { row -> !row.isNullOrBlank() }
                    .map{ row -> row.chunked(3) { t -> t.trim().toString().toInt() }
            }
            return BingoBoard(matrix)
        }
    }
}
