package day03

class LifeSupportRatingCalculator(rawReadings:String): PowerConsumptionCalculator(rawReadings){

    override fun  calculate(): Int = getOxygenGeneratorRating() * getCo2ScrubberRating()

    fun getOxygenGeneratorRating(): Int {
        val columns = inputToColumns()
        val mostRepBits = Integer.toBinaryString(calculateMostRepresentedBitsInColumns(columns))

        var bitrows = inputToRows()

        // mostRepBits.forEachIndexed { x, mvb -> bitrows.forEachIndexed { y, row -> if (bitrows[y][x] != Character.getNumericValue(mvb)) bitrows.remove } }

        return Int.MIN_VALUE
    }

    private fun inputToRows(): List<List<Int>> {
        return readings.map { it.chunked(1) { it.toString().toInt() } }
    }

    fun getCo2ScrubberRating(): Int {
        return Int.MIN_VALUE
    }
}