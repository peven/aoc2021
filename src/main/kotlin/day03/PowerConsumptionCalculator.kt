package day03

open class PowerConsumptionCalculator(rawReadings:String) {
    protected val readings: List<String> = rawReadings.reader().readLines()

    protected fun inputToColumns(): MutableList<String> {
        val columns = mutableListOf<String>()

        readings.forEach { binaryNumber ->
            binaryNumber.forEachIndexed { index, bit ->
                if (columns.count() == index) columns.add(index, "")
                columns[index] += bit.toString()
            }
        }

        return columns
    }

    protected fun calculateMostRepresentedBitsInColumns(columns: MutableList<String>): Int {
        return columns.map{ it.fold(0) { acc, i -> acc + Character.getNumericValue(i) }}
            .fold("") { acc, occurrence -> acc +
                    when { 2 * occurrence > columns.first().count() -> "1"; else -> "0" }
            }
            .fold("") { acc, columnAggregatedValue -> acc.plus(columnAggregatedValue) }.toInt(2)
    }

    protected fun calculateLeastRepresentedBitsInColumns(gammaRate: Int): Int {
        val binaryMask = Integer.toBinaryString(gammaRate).replace("0","1").toInt(2)
        println("(${Integer.toBinaryString(gammaRate)}/$gammaRate) : ${gammaRate.inv()} and $binaryMask = ${gammaRate.inv() and binaryMask}")
        return gammaRate.inv() and binaryMask
    }

    open fun calculate(): Int {
        return  calculateMostRepresentedBitsInColumns(inputToColumns()).let { gammaRate -> gammaRate * calculateLeastRepresentedBitsInColumns(gammaRate)}
    }
}