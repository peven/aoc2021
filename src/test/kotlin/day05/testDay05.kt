package day05

import org.junit.jupiter.api.Test
import java.lang.Integer.*
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

    val intermediateCheckpoint = ".......1..\n" +
            "..1....1..\n" +
            "..1....1..\n" +
            ".......1..\n" +
            ".112111211\n" +
            "..........\n" +
            "..........\n" +
            "..........\n" +
            "..........\n" +
            "222111...."

    @Test
    fun checkLineTypes() {
        assertEquals(Line(Point(1,4), Point(4,4)).type, LINETYPE.Horizontal)
        assertEquals(Line(Point(4,1), Point(4,4)).type, LINETYPE.Vertical)
        assertEquals(Line(Point(1,4), Point(1,4)).type, LINETYPE.Dot)
        assertEquals(Line(Point(5,1), Point(3,7)).type, LINETYPE.Angled)
    }

    @Test
    fun mapStringEntryToTwoPoints(){
        val stringEntry = "5,5 -> 8,2"

        val result = stringEntry.split(" -> ").map{ it -> Point(it.split(',').map { i -> i.toInt()}) }

        val expected = listOf<Point>(Point(5,5),Point(8,2))

        assertEquals(expected,result)
    }

    @Test
    fun mapStringEntryToLine(){
        val stringEntry = "5,5 -> 8,2"

        val result = stringEntry.let{ Line(it.split(" -> ").map{ it -> Point(it.split(',').map { i -> i.toInt()}) })}

        val expected = Line(Point(5,5),Point(8,2))

        assertEquals(expected, result)
    }

    private fun linify(stringLines: List<String>): List<Line> = stringLines.map{ Line(it.split(" -> ").map{ it -> Point(it.split(',').map { i -> i.toInt()}) })}

    @Test
    fun countOverlapsOnSample(){
        val lines = linify(sampleInput.reader().readLines())
        val result = lines.flatMap{ getPointsOf(it) }.groupingBy { it }.eachCount().filterValues { it > 1 }.count()
        val expected = 5;
        assertEquals(expected, result)
    }

    private fun getPointsOf(it: Line):List<Point> {
        return when (it.type) {
            LINETYPE.Horizontal -> getHorizontalPointsBetween(it.pointOne,it.pointTwo)
            LINETYPE.Vertical -> getVerticalPointsBetween(it.pointOne,it.pointTwo)
            LINETYPE.Dot -> listOf(it.pointOne)
            else -> emptyList()
        }
    }

    private fun getVerticalPointsBetween(pointOne: Point, pointTwo: Point): List<Point> {
        val lower = min(pointOne.ordinate,pointTwo.ordinate)
        val upper = max(pointOne.ordinate,pointTwo.ordinate)
       return (lower..upper).map { x -> Point(pointOne.abscissa,x) }
    }

    private fun getHorizontalPointsBetween(pointOne: Point, pointTwo: Point): List<Point> {
        val lower = min(pointOne.abscissa,pointTwo.abscissa)
        val upper = max(pointOne.abscissa,pointTwo.abscissa)
        return (lower..upper).map { x -> Point(x,pointOne.ordinate) }
    }
}