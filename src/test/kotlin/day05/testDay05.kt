package day05

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class testDay05 {

    val sampleInput = "0,9 -> 5,9\n" +
            "8,0 -> 0,8\n" +
            "9,4 -> 3,4\n" +
            "2,2 -> 2,1\n" +
            "7,0 -> 7,4\n" +
            "6,4 -> 2,0\n" +
            "0,9 -> 2,9\n" +
            "3,4 -> 1,4\n" +
            "0,0 -> 8,8\n" +
            "5,5 -> 8,2"

    @Test
    fun checkLineTypes() {
        assertEquals(Line(Point(1,4), Point(4,4)).type, LINETYPE.Horizontal)
        assertEquals(Line(Point(4,1), Point(4,4)).type, LINETYPE.Vertical)
        assertEquals(Line(Point(1,4), Point(1,4)).type, LINETYPE.Dot)
        assertEquals(Line(Point(5,1), Point(3,7)).type, LINETYPE.Diagonal)
    }

    @Test
    fun mapStringEntryToTwoPoints(){
        val stringEntry = "5,5 -> 8,2"
        val result = stringEntry.split(" -> ").map{ it -> Point(it.split(',').map { i -> i.toInt()}) }
        val expected = listOf(Point(5,5),Point(8,2))
        assertEquals(expected,result)
    }

    @Test
    fun mapStringEntryToLine(){
        val stringEntry = "5,5 -> 8,2"
        val result = Line(stringEntry.split(" -> ").map{ p -> Point(p.split(',').map { i -> i.toInt()}) })
        val expected = Line(Point(5,5),Point(8,2))
        assertEquals(expected, result)
    }

    @Test
    fun countOverlapsOnSampleExcludingDiagonals(){
        val lines = Line.linify(sampleInput.reader().readLines())
        val result = lines.flatMap{ Point.getPointsOf(it) }.groupingBy { it }.eachCount().filterValues { it > 1 }.count()
        val expected = 5
        assertEquals(expected, result)
    }

    @Test
    fun countOverlapsOnSample(){
        val lines = Line.linify(sampleInput.reader().readLines())
        val result = lines.flatMap{ Point.getPointsOf(it,false) }.groupingBy { it }.eachCount().filterValues { it > 1 }.count()
        val expected = 12
        assertEquals(expected, result)
    }
}