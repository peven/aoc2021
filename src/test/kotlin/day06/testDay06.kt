package day06

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class testDay06 {

    val sampleLanternfishSchool = "3,4,3,1,2"

    val sampleFirst18iterations =
            "3,4,3,1,2\n" +
            "2,3,2,0,1\n" +
            "1,2,1,6,0,8\n" +
            "0,1,0,5,6,7,8\n" +
            "6,0,6,4,5,6,7,8,8\n" +
            "5,6,5,3,4,5,6,7,7,8\n" +
            "4,5,4,2,3,4,5,6,6,7\n" +
            "3,4,3,1,2,3,4,5,5,6\n" +
            "2,3,2,0,1,2,3,4,4,5\n" +
            "1,2,1,6,0,1,2,3,3,4,8\n" +
            "0,1,0,5,6,0,1,2,2,3,7,8\n" +
            "6,0,6,4,5,6,0,1,1,2,6,7,8,8,8\n" +
            "5,6,5,3,4,5,6,0,0,1,5,6,7,7,7,8,8\n" +
            "4,5,4,2,3,4,5,6,6,0,4,5,6,6,6,7,7,8,8\n" +
            "3,4,3,1,2,3,4,5,5,6,3,4,5,5,5,6,6,7,7,8\n" +
            "2,3,2,0,1,2,3,4,4,5,2,3,4,4,4,5,5,6,6,7\n" +
            "1,2,1,6,0,1,2,3,3,4,1,2,3,3,3,4,4,5,5,6,8\n" +
            "0,1,0,5,6,0,1,2,2,3,0,1,2,2,2,3,3,4,4,5,7,8\n" +
            "6,0,6,4,5,6,0,1,1,2,6,0,1,1,1,2,2,3,3,4,6,7,8,8,8,8"

    val sampleFishCountAfter80days = 5934

    @Test
    fun decrementFish() {
        var school = Lanternfish.fishify(sampleLanternfishSchool.split(',').map { it.toInt()})
        school = evolve(school,1)
        var expectedState = listOf(2,3,2,0,1).map{ Lanternfish(it)}
        assertEquals(expectedState, school)
    }

    private fun evolve(school: List<Lanternfish>, days: Int): List<Lanternfish> {

        return school.map { Lanternfish(it.internalClock - 1) }
    }
}