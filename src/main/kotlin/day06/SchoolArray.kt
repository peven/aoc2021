package day06

data class SchoolArray(private var fishes:LongArray) {

    companion object {
        fun buildSchoolArray(schoolAsString: String): LongArray {
            return schoolAsString.split(',').map { it.toInt() }.fold(LongArray(9) { 0 }) { acc, i -> acc[i]++; return@fold acc }
        }
    }

    fun evolve(days: Int): LongArray {
        repeat(days) {
            fishes = evolveOnce(fishes)
        }
        return fishes
    }

    private fun LongArray.rotateLeftInPlace() {
        val leftMost = first()
        this.copyInto(this, startIndex = 1)
        this[this.lastIndex] = leftMost
    }

    private fun evolveOnce(fishes: LongArray): LongArray {
        fishes.rotateLeftInPlace()
        fishes[6]+=fishes[8]
        return fishes
    }
}