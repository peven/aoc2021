package day06

import java.io.File

private fun readEntry(filePath:String):List<Int> = File(filePath).readText().split(',').map{ it.toInt() }

fun main() {
    val schoolOfLanternfish = Lanternfish.fishify(readEntry(".\\src\\main\\kotlin\\day06\\input.txt"))

    val resultPartOne = partOne(schoolOfLanternfish)
    println("Result for part #1 is $resultPartOne.")

    val resultPartTwo = partTwo(schoolOfLanternfish)
    println("Result for part #2 is $resultPartTwo.")
}

private fun partOne(school: List<Lanternfish>): Int {
    return school.count()
}

private fun partTwo(school: List<Lanternfish>): Int {
    return school.count()
}
