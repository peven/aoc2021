package day06

import java.io.File

private fun readEntry(filePath:String):SchoolArray = SchoolArray(SchoolArray.buildSchoolArray(File(filePath).readText()))

fun main() {
    val filePath = ".\\src\\main\\kotlin\\day06\\input.txt"

    println("Result for part #1 is ${partOne(readEntry(filePath))}.")
    println("Result for part #2 is ${partTwo(readEntry(filePath))}.")
}

private fun partOne(school: SchoolArray): Long {
    val result = school.evolve(80)
    return result.sum()
}

private fun partTwo(school: SchoolArray): Long {
    val result = school.evolve(256)
    return result.sum()
}
