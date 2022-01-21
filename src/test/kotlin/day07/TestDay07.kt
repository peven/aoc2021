package day07

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestDay07 {

    private val sampleData = "16,1,2,0,4,2,7,1,2,14"

    @Test
    fun averageOfSampleData() {
        val positions = sampleData.split(',').map{it.toInt()}.sorted()
        val mean = CrabCoordinator(positions).getMean()
        assertThat(mean).isEqualTo(5)
    }

    @Test
    fun medianOfSampleData() {
        val positions= sampleData.split(',').map{it.toInt()}.sorted()
        val median = CrabCoordinator(positions).getMedian()
        assertThat(median).isEqualTo(2)
    }


    @Test
    fun sumMovementsToMedianForSampleData() {
        val sortedPositions= sampleData.split(',').map{it.toInt()}.sorted()
        val crabs = CrabCoordinator(sortedPositions)
        val median = crabs.getMedian()
        val fuel = crabs.calculateFuel(median)
        assertThat(fuel).isEqualTo(37)
    }

    @Test
    fun sumMovementsToMeanForSampleData() {
        val sortedPositions = sampleData.split(',').map{it.toInt()}.sorted()
        val crabs = CrabCoordinator(sortedPositions)
        val mean = crabs.getMean()
        val fuel = crabs.calculateFastBurningFuel(mean)
        assertThat(fuel).isEqualTo(168)
    }
}