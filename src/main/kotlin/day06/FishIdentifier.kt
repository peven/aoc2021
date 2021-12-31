package day06

class FishIdentifier : IdAuthority {

    var lastId: Int = 0

    override fun GetNextId(): Int {
        return lastId++
    }
}
