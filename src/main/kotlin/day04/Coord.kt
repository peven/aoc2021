package day04

data class Coord(val rowIndex: Int, val columnIndex: Int) {
    fun plus(coord: Coord):Coord {
        return Coord(this.rowIndex + coord.rowIndex, this.columnIndex + coord.columnIndex)
    }
}
