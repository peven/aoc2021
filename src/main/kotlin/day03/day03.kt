import day03.PowerConsumptionCalculator
import java.io.File

fun main() {
    val filePath = ".\\src\\main\\kotlin\\day03\\input.txt"
    val powerConsumptionCalculator = PowerConsumptionCalculator(File(filePath).readText())
    val powerConsumption = powerConsumptionCalculator.calculate()
    println("Power Consumption Ratio is $powerConsumption")
}

