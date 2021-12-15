package day03

import day03.LifeSupportRatingCalculator.Comparor.compareGET
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class testDay03 {

    var rowShortSample = listOf("10011","01001","10110","11100")

    private val sampleInput = buildString {
        appendLine("00100")
        appendLine("11110")
        appendLine("10110") //22
        appendLine("10111")
        appendLine("10101")
        appendLine("01111")
        appendLine("00111")
        appendLine("11100")
        appendLine("10000")
        appendLine("11001")
        appendLine("00010")
        appendLine("01010") //10
    }

    @Test
    fun calculatePowerConsumption() {
        val resultingPowerConsumption = PowerConsumptionCalculator(sampleInput).calculate()
        val expectedPowerConsumption = 198
        assertEquals(expectedPowerConsumption, resultingPowerConsumption)
    }

    @Test
    fun howtoReduce() {
        val bits: List<Int> = listOf(1, 0, 0, 1, 0)
        val result = bits.reduce { acc, i ->  acc + i}.div(bits.count())
        println(result)
    }

    private fun buildMatrix(rows: List<String>) = rows.map { it.chunked(1) { bit: CharSequence -> bit.toString().toInt() } }

    @Test
    fun transformBinaryStringRowsToIntegerMatrix() {
        val result = buildMatrix(rowShortSample)
        val expected = listOf(listOf(1,0,0,1,1),listOf(0,1,0,0,1),listOf(1,0,1,1,0),listOf(1,1,1,0,0))
        assertEquals(expected, result)
    }

    @Test
    fun filterOutBinaryRowsStartingWithOne() {
        val result = buildMatrix(rowShortSample).filter {it.first()!=1 }
        val expected = listOf(listOf(0,1,0,0,1))
        assertEquals(expected, result)
    }

    @Test
    fun filterOutBinaryRowsWithLeastRecurringValue(){
        val matrix = buildMatrix(rowShortSample)
        val result = LifeSupportRatingCalculator(sampleInput).extractValueFromMatrix(matrix, ::compareGET)

        val expected = listOf(1,0,1,1,0).toInt()
        assertEquals(expected, result)
    }


    @Test
    fun calculateOxygenGeneratorRating() {
        val oxygenGeneratorRating = LifeSupportRatingCalculator(sampleInput).getOxygenGeneratorRating()
        val expectedRating = 23
        assertEquals(expectedRating, oxygenGeneratorRating)
    }

    @Test
    fun calculateCo2ScrubberRatingForOneBinaryNumber() {
        val co2ScrubberRating = LifeSupportRatingCalculator("1010").getCo2ScrubberRating()
        val expectedRating = 10
        assertEquals(expectedRating, co2ScrubberRating)
    }
    @Test
    fun calculateCo2ScrubberRatingForFourBinaryNumbers() {
        val input = buildString {
            appendLine("00110") //6
            appendLine("00011") //3
            appendLine("11110") //30
            appendLine("10110") //22
            appendLine("11010") //26
        }

        val co2ScrubberRating = LifeSupportRatingCalculator(input).getCo2ScrubberRating()
        val expectedRating = 3
        assertEquals(expectedRating, co2ScrubberRating)
    }

    @Test
    fun calculateCo2ScrubberRatingOnlyOnesInFirstColumnException() {
        val input = buildString {
            appendLine("10110") //22
            appendLine("10011") //19
            appendLine("11110") //30
            appendLine("10110") //22
            appendLine("11010") //26
        }

        val co2ScrubberRating = LifeSupportRatingCalculator(input).getCo2ScrubberRating()
        val expectedRating = 26
        assertEquals(expectedRating, co2ScrubberRating)
    }

    @Test
    fun calculateCo2ScrubberRating() {
        val co2ScrubberRating = LifeSupportRatingCalculator(sampleInput).getCo2ScrubberRating()
        val expectedRating = 10
        assertEquals(expectedRating, co2ScrubberRating)
    }

    @Test
    fun calculateLifeSupportRating() {
        val resultingLifeSupportRating = LifeSupportRatingCalculator(sampleInput).calculate()
        val expectedLifeSupportRating = 230
        assertEquals(expectedLifeSupportRating, resultingLifeSupportRating)
    }
}

private fun <Int> Iterable<Int>.toInt(): kotlin.Int {
    return this.fold("") { acc, value -> acc.plus(value.toString())}.toInt(2)
}
