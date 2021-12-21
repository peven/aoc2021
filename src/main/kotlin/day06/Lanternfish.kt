package day06

data class Lanternfish(var internalClock: Int) {
    companion object {
        fun fishify(fish: List<Int>): List<Lanternfish> {
            return fish.map { Lanternfish(it) }
        }
    }
}
