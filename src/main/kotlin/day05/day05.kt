package day05

import java.io.File

private fun readMeasurements(filePath:String):List<Int> = File(filePath).readLines().map { it.toInt()}

fun main() {
    val measurements = readMeasurements(".\\src\\main\\kotlin\\day05\\input.txt")

    val result=0

    println("Result is $result")
}

