package day06

import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.direct
import java.io.File

private fun readEntry(filePath:String):List<Lanternfish> = File(filePath).readText().split(',').map{ Lanternfish(it.toInt()) }

fun main() {
    val kodein = DI {
        bindSingleton<IdAuthority> { FishIdentifier() }
    }

    kodein.direct.directDI

    val schoolOfLanternfish by kodein.di { School(readEntry(".\\src\\main\\kotlin\\day06\\input.txt"),instance()) }

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
