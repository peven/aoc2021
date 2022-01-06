package day06

import org.junit.jupiter.api.Test
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance
import org.kodein.di.newInstance
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class testDay06 {

    val sampleLanternfishSchool = "3,4,3,1,2"

    val sampleFishCountAfter80days = 5934
    val sampleFishCountAfter256days = 26984457539

    @Test
    fun decrementFish() {
        val idAuthority: IdAuthority = FishIdentifier()
        var school = School((sampleLanternfishSchool.split(',').map { Lanternfish(idAuthority.GetNextId(), it.toInt(), idAuthority)}), idAuthority)
        school = school.evolve()
        val expectedState = School(listOf(Pair(0,2),Pair(1,3),Pair(2,2),Pair(3,0),Pair(4,1)).map{ Lanternfish(it.first,it.second, idAuthority) }, idAuthority)
        assertEquals(expectedState, school)
    }

    @Test
    fun instanciateSingleton() {
        val kodein = DI {
            bindSingleton<IdAuthority> { FishIdentifier() }
        }

        val testOne by kodein.di.newInstance { TestInjection("One", instance()) }
        val testTwo by kodein.di.newInstance { TestInjection("Two", instance()) }

        val firstId = testOne.getNextId()
        val secondId = testTwo.getNextId()

        assertEquals(firstId,0)
        assertEquals(secondId,1)
    }


    @Test
    fun SpawnNewFish() {
        val idAuthority: IdAuthority = FishIdentifier()
        var school = School(listOf(Lanternfish(idAuthority.GetNextId(), 0, idAuthority)), idAuthority)
        school = school.evolve()
        val expectedState = School(listOf(Pair(0,8),Pair(1,6)).map{ Lanternfish(it.first,it.second,idAuthority) },idAuthority)
        assertEquals(expectedState, school)
    }

    @Test
    fun sample80daysBruteForceCount() {
        val idAuthority: IdAuthority = FishIdentifier()
        var school = School((sampleLanternfishSchool.split(',').map { Lanternfish(idAuthority.GetNextId(), it.toInt(), idAuthority)}), idAuthority)
        for (round in 1..80) { school = school.evolve() }
        val expectedState = sampleFishCountAfter80days
        assertEquals(expectedState, school.count())
    }

    @Test
    fun foldSchoolToArrayOfFishCountPerInternalClockValue()
    {
        val lanterns = buildSchoolArray(sampleLanternfishSchool)
        val expected = longArrayOf(0, 1, 1, 2, 1, 0, 0, 0, 0)
        assertContentEquals(expected,lanterns)
    }

    @Test
    fun sample5daysEnsemblistCount()
    {
        val lanterns = SchoolArray(SchoolArray.buildSchoolArray(sampleLanternfishSchool))
        val result = lanterns.evolve(5).sum()
        val expected = 10L
        assertEquals(expected,result)
    }

    private fun buildSchoolArray(schoolAsString: String): LongArray {
        return schoolAsString.split(',').map { it.toInt() }.fold(LongArray(9) { 0 }) { acc, i -> acc[i]++; return@fold acc }
    }

    @Test
    fun sample80daysEnsemblistCount()
    {
        val lanterns = SchoolArray(SchoolArray.buildSchoolArray(sampleLanternfishSchool))
        val result = lanterns.evolve(80).sum()
        val expected = sampleFishCountAfter80days.toLong()
        assertEquals(expected,result)
    }

    @Test
    fun sample256daysEnsemblistCount()
    {
        val lanterns = SchoolArray(SchoolArray.buildSchoolArray(sampleLanternfishSchool))
        val result = lanterns.evolve(256).sum()
        val expected = sampleFishCountAfter256days
        assertEquals(expected,result)
    }

    @Test
    fun shiftFishLeft()
    {
        val input = longArrayOf(0, 1, 0, 0, 0, 0, 0, 0, 0)
        val lanterns: LongArray = evolve(input)
        val expected = longArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0)
        assertContentEquals(expected,lanterns)
    }

    private fun evolve(fish: LongArray): LongArray {
        var current:Long
        var previous:Long = fish[0]
        val birth:Long = fish[0]
        for (i in 8 downTo  0) {
            current = fish[i]
            fish[i] = if (i == 6) previous + birth; else previous
            previous = current
        }

        return fish
    }

    @Test
    fun respawnFishOnRightSide()
    {
        val input = longArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0)
        val lanterns: LongArray = evolve(input)
        val expected = longArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1)
        assertEquals(lanterns[7],expected[7])
    }

    @Test
    fun birthAndRespawnFishOnRightSide()
    {
        val input = longArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0)
        val lanterns: LongArray= evolve(input)
        val expected = longArrayOf(0, 0, 0, 0, 0, 0, 1, 0, 1)
        assertContentEquals(expected,lanterns)
    }
}

data class TestInjection(private val name:String, private val idAuthority: IdAuthority) {
    fun getNextId() = idAuthority.GetNextId()
}