package day01

import java.io.File

private fun readMeasurements(filePath:String):List<Int> = File(filePath).readLines().map { it.toInt()}

fun main() {
    val depthMeasurements = readMeasurements(".\\src\\main\\kotlin\\day01\\input.txt")

    val count=(1 until depthMeasurements.count()-2).count {(depthMeasurements[it]+depthMeasurements[it+1]+depthMeasurements[it+2]-(depthMeasurements[it-1]+depthMeasurements[it]+depthMeasurements[it+1])>0) }

    println("$count measurements are larger than the previous one")
}

