import day03.LifeSupportRatingCalculator
import day03.PowerConsumptionCalculator
import java.io.File

fun main() {
    val filePath = ".\\src\\main\\kotlin\\day03\\input.txt"
    println("Part #1 ----")
    val powerConsumptionCalculator = PowerConsumptionCalculator(File(filePath).readText())
    val powerConsumption = powerConsumptionCalculator.calculate()
    println("Power Consumption Ratio is $powerConsumption")

    println("Part #2 ----")
    val lifeSupportRatingCalculator = LifeSupportRatingCalculator(File(filePath).readText())
    val lifeSupportRating = lifeSupportRatingCalculator.calculate()
    println("Life Support Rating is $lifeSupportRating")
}

