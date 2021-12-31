package day06

data class Lanternfish(val id: Int, val internalClock: Int)

data class School(private val fish: List<Lanternfish>, private val identifier: IdAuthority){

    fun evolve(days: Int = 1): School {
        return School(fish.map { Lanternfish( identifier.GetNextId(), it.internalClock - days) }, identifier)
    }
}