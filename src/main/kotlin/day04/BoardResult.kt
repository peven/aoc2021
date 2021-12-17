package day04

data class BoardResult(val boardSize: Int) {
    var horizontal = mutableMapOf<Int,Int>()
    var vertical = mutableMapOf<Int,Int>()
    var coordinates = mutableListOf<Coord>()

    fun append(coord: Coord) {
        coordinates.add(coord)
        horizontal.merge(coord.columnIndex,1,Int::plus)
        vertical.merge(coord.rowIndex,1,Int::plus)
    }

    fun isBingo(): Boolean {
        return horizontal.containsValue(boardSize) || vertical.containsValue(boardSize)
    }
}
