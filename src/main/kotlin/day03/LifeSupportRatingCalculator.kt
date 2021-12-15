package day03

class LifeSupportRatingCalculator(rawReadings: String) : PowerConsumptionCalculator(rawReadings) {

    override fun calculate(): Int = getOxygenGeneratorRating() * getCo2ScrubberRating()

    private fun buildMatrix(rows: List<String>) =
        rows.map { it.chunked(1) { bit: CharSequence -> bit.toString().toInt() } }

    companion object Comparor {
        fun compareGET(i: Int, j: Int): Int {
            return when {
                i > j -> 1; i < j -> 0; else -> 1
            }
        }

        fun compareLT(i: Int, j: Int): Int {
            return when {
                (i == 2 * j) -> 1       // Only 1s
                (i == 0) -> 0           // Only 0s
                (i > j) -> 0            // Minority is 0
                (i in 1 until j) -> 1   // Minority is 1
                else -> 0
            }
        }
    }

    fun extractValueFromMatrix(matrix: List<List<Int>>, comparison: (Int, Int) -> Int): Int {
        var local = matrix

        for (colIndex in 0 until local.first().count()) {
            if (local.count() == 1) break

            val mostRecurringBit = comparison(local.sumOf { 2 * it[colIndex] }, local.count())

            local = local.filter { it[colIndex] == mostRecurringBit }
        }
        return local.first().fold("") { acc, it -> acc.plus(it.toString()) }.toInt(2)
    }

    fun getOxygenGeneratorRating(): Int {
        return extractValueFromMatrix(buildMatrix(readings), ::compareGET)
    }

    fun getCo2ScrubberRating(): Int {
        return extractValueFromMatrix(buildMatrix(readings), ::compareLT)
    }
}