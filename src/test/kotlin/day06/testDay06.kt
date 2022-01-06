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
    fun sample80daysCount() {
        val idAuthority: IdAuthority = FishIdentifier()
        var school = School((sampleLanternfishSchool.split(',').map { Lanternfish(idAuthority.GetNextId(), it.toInt(), idAuthority)}), idAuthority)
        for (round in 1..80) { school = school.evolve() }
        val expectedState = sampleFishCountAfter80days
        assertEquals(expectedState, school.count())
    }

    @Test
    fun foldSchoolToArrayOfFishCountPerInternalClockValue()
    {
        val lanterns = sampleLanternfishSchool.split(',').map { it.toInt() }.fold(Array<Long>(8) { 0 }) { acc, i -> acc[i]++; return@fold acc }
        val expected = arrayOf<Long>(0, 1, 1, 2, 1, 0, 0, 0)
        assertContentEquals(expected,lanterns)
    }
}

data class TestInjection(private val name:String, private val idAuthority: IdAuthority) {
    fun getNextId() = idAuthority.GetNextId()
}