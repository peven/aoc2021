package day07

import java.io.File

private fun readEntry(filePath:String): List<Int> = File(filePath).readText().split(',').map{ it.toInt()}

fun main() {
    val filePath = ".\\src\\main\\kotlin\\day07\\input.txt"

    println("Result for part #1 (median) is ${partOne(readEntry(filePath).sorted())}.")
    println("Result for part #2 (mean-1..mean+1) is ${partTwo(readEntry(filePath).sorted())}.")
    println("Result for part #2 (brute force) is ${partTwoBruteForce(readEntry(filePath).sorted())}.")
}

private fun partOne(sortedPositions: List<Int>): Int {
    val crabCoordinator = CrabCoordinator(sortedPositions)
    val median = crabCoordinator.getMedian()
    println("median= $median")
    return crabCoordinator.calculateFuel(median)
}

private fun partTwo(sortedPositions: List<Int>): Int {
    val crabCoordinator = CrabCoordinator(sortedPositions)
    val mean = crabCoordinator.getMean()
    // Not sure why mean rounded to the closest value (up) didn't satisfy the problem.
    // Using a range of nearest integers and keeping minOf solved it.
    val range = IntRange(mean.dec(),mean.inc())
    return range.minOf {crabCoordinator.calculateFastBurningFuel(it)}
}

private fun partTwoBruteForce(sorted: List<Int>): Int {
    val crabCoordinator = CrabCoordinator(sorted)
    return crabCoordinator.calculateBestBurningFuelForRange()
}

