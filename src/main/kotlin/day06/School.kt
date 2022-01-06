package day06

data class School(private val fish: List<Lanternfish>, private val identifier: IdAuthority){

    fun evolve(days: Int = 1): School {
        return School(
            fish.fold(mutableListOf()) { acc, fishy -> (acc + fishy.evolve(days)) as MutableList<Lanternfish> },
            identifier
        )
    }

    fun count(): Int = fish.count()
}