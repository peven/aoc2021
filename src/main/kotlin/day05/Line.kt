package day05


data class Line(val pointOne: Point, val pointTwo: Point) {
    constructor(points: List<Point>) : this(points.first(), points.last())

    val type: LINETYPE = when {
        pointOne.abscissa==pointTwo.abscissa
          && pointOne.ordinate==pointTwo.ordinate -> LINETYPE.Dot
        pointOne.abscissa==pointTwo.abscissa -> LINETYPE.Vertical
        pointOne.ordinate==pointTwo.ordinate -> LINETYPE.Horizontal
        else -> LINETYPE.Angled }
}

enum class LINETYPE {
    Horizontal,
    Vertical,
    Dot,
    Angled
}

data class Point(val abscissa: Int, val ordinate: Int) {
    constructor(point: List<Int>) : this(point.first(),point.last())
}
