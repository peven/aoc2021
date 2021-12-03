import java.io.File
import kotlin.collections.ArrayDeque

fun main() {
    val depthMeasurements = File(".\\src\\main\\kotlin\\day01\\input.txt").readLines().map { it.toInt()}
    val slidingWindow: ArrayDeque<Int> =  ArrayDeque(3)
    var count=0
    var previousWindow = 0

    depthMeasurements.forEach { value ->
        slidingWindow.add(value)
        println(slidingWindow)
        when {
            slidingWindow.count()<3 -> println("N/A - no previous measurement")
            slidingWindow.sum()-previousWindow>0 -> {
                println("increased")
                count++
            }
            else -> println("decreased")
        }
        previousWindow = slidingWindow.sum()
        if (slidingWindow.count()==3)
            slidingWindow.removeFirst()
    }

    println("$count measurements are larger than the previous one")
}

