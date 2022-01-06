package day06

data class Lanternfish(val id: Int, val internalClock: Int, private val identifier: IdAuthority) {
    fun evolve(days: Int):MutableList<Lanternfish> {
        val currentClock = internalClock-days
        if (currentClock==-1)
            return mutableListOf(Lanternfish(id,8,identifier), Lanternfish(identifier.GetNextId(),6, identifier))
        return mutableListOf(Lanternfish(id,currentClock, identifier))
    }
}

