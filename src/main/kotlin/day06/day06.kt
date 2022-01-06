package day06

import java.io.File

private fun readEntry(idAuthority: IdAuthority, filePath:String):List<Lanternfish> =
    File(filePath).readText().split(',').map{ Lanternfish(idAuthority.GetNextId(), it.toInt(), idAuthority) }

fun main() {
    val idAuthority = FishIdentifier()
    val listOfFish = readEntry(idAuthority, ".\\src\\main\\kotlin\\day06\\input.txt")
    val schoolOfLanternfish =  School(listOfFish,idAuthority)

    val resultPartOne = partOne(schoolOfLanternfish)
    println("Result for part #1 is $resultPartOne.")

    val resultPartTwo = partTwo(schoolOfLanternfish)
    println("Result for part #2 is $resultPartTwo.")
}

private fun partOne(school: School): Int {
    var schoolOfFish = school
    for (round in 1..80) {  println("round $round"); schoolOfFish = schoolOfFish.evolve(); }
   return schoolOfFish.count()
}

private fun partTwo(school: School): Int {
    return school.count()
}
