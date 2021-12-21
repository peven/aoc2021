package day05

data class Point(val abscissa: Int, val ordinate: Int) {
    constructor(point: List<Int>) : this(point.first(),point.last())

    companion object {
        fun getPointsOf(it: Line, excludeDiagonals:Boolean=true):List<Point> {
            return when (it.type) {
                LINETYPE.Horizontal -> getPointsBetween(it.pointOne,it.pointTwo)
                LINETYPE.Vertical -> getPointsBetween(it.pointOne,it.pointTwo)
                LINETYPE.Diagonal -> if (excludeDiagonals) emptyList(); else getPointsBetween(it.pointOne,it.pointTwo)
                LINETYPE.Dot -> listOf(it.pointOne)
            }
        }

        private fun getPointsBetween(pointOne: Point, pointTwo: Point): List<Point> {
            val step = getLineProgression(pointOne, pointTwo)
            var point = pointOne
            val points = mutableListOf<Point>()
            while (point!=pointTwo.plus(step))
            {
                points.add(point)
                point += step
            }
            return points
        }

        private fun getStep(x: Int, y: Int) =
            when {
                x > y -> -1
                x < y -> 1
                else -> 0
            }

        private fun getLineProgression(pointOne: Point, pointTwo: Point) = Point(getStep(pointOne.abscissa, pointTwo.abscissa), getStep(pointOne.ordinate, pointTwo.ordinate))
    }

    private operator fun plus(vector: Point): Point {
        return Point(this.abscissa+vector.abscissa, this.ordinate+vector.ordinate)
    }
}