package day07

import kotlin.math.abs
import kotlin.math.roundToInt

class CrabCoordinator(private val positions: List<Int>) {

    fun getMedian(): Int {
        return when (positions.size % 2) {
            0 -> {
                val p = positions.size/2
                positions[p]
            }
            else -> {
                val p = (positions.size+1)/2
                (positions[p]+positions[p+1])/2
            }
        }
    }

    fun getMean(): Int {
        check(positions.isNotEmpty())
        val mean = (positions.sum()/positions.size.toDouble())
        return mean.roundToInt()
    }

    fun calculateBestBurningFuelForRange(): Int {
        check(positions.isNotEmpty())
        val range = positions.toRange()
        return range.minOf { calculateFastBurningFuel(it) }
    }

    private fun totalFuel(position: Int, burn: (Int)->Int) = positions.fold(0) { acc, crab -> acc + burn(abs(crab - position)) }

    private fun burnSlow(distance:Int):Int {
        return distance
    }

    private fun burnFast(distance:Int):Int {
        return distance*(distance+1)/2
    }

    fun calculateFuel(position:Int) : Int {
        return totalFuel(position) { burnSlow(it) }
    }

    fun calculateFastBurningFuel(position: Int): Int {
        return totalFuel(position) { burnFast(it)}
    }
}

private fun List<Int>.toRange(): IntRange {
    return this.minOf {it}..this.maxOf{it}
}
