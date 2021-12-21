package day05

import java.io.File

private fun readLines(filePath:String):List<String> = File(filePath).readLines()

fun main() {
    val lines = Line.linify(readLines(".\\src\\main\\kotlin\\day05\\input.txt"))

    val resultPartOne = partOne(lines)
    println("Result for part #1 is $resultPartOne.")

    val resultPartTwo = partTwo(lines)
    println("Result for part #2 is $resultPartTwo.")
}


private fun partOne(lines: List<Line>): Int {
    return lines.flatMap { Point.getPointsOf(it) }.groupingBy { it }.eachCount().filterValues { it > 1 }.count()
}

private fun partTwo(lines: List<Line>): Int {
    return lines.flatMap { Point.getPointsOf(it,false) }.groupingBy { it }.eachCount().filterValues { it > 1 }.count()
}
