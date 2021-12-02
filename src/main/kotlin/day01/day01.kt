import java.io.File

fun main() {
    val depthMeasurements = File(".\\src\\main\\kotlin\\day01\\input.txt").readLines().map { it.toInt()}
    var previous = 0
    var count=0

    depthMeasurements.forEach { value ->
        when {
            previous==0 -> println("N/A - no previous measurement")
            value-previous>0 -> {
                println("increased")
                count++
            }
            else -> println("decreased")
        }
        previous = value
    }

    println("$count measurements are larger than the previous one")
}