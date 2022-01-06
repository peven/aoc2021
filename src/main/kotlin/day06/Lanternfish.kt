package day06

data class Lanternfish(val id: Int, val internalClock: Int, private val identifier: IdAuthority) {
    fun evolve(days: Int):MutableList<Lanternfish> {
        val currentClock = internalClock-days
        if (currentClock==-1)
            return mutableListOf(Lanternfish(id,8,identifier), Lanternfish(identifier.GetNextId(),6, identifier))
        return mutableListOf(Lanternfish(id,currentClock, identifier))
    }
}

data class School(private val fish: List<Lanternfish>, private val identifier: IdAuthority){

    fun evolve(days: Int = 1): School {
        return School(fish.fold(mutableListOf<Lanternfish>()) { acc, fishy -> (acc + fishy.evolve(days)) as MutableList<Lanternfish> }, identifier)
    }

    fun count(): Int = fish.count()
}