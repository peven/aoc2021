package day05

import java.io.File

private fun readLines(filePath:String):List<String> = File(filePath).readLines()

fun main() {
    val lines = readLines(".\\src\\main\\kotlin\\day05\\input.txt")

    val result=0

    println("Result is $result")
}

