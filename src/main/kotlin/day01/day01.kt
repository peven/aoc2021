import java.io.File

fun main() {
    val depthMeasurements = File(".\\src\\main\\kotlin\\day01\\input.txt").readLines().map { it.toInt()}

    val count=(1 until depthMeasurements.count()-2).count {(depthMeasurements[it]+depthMeasurements[it+1]+depthMeasurements[it+2]-(depthMeasurements[it-1]+depthMeasurements[it]+depthMeasurements[it+1])>0) }

    println("$count measurements are larger than the previous one")
}

