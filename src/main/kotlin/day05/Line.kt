package day05


data class Line(val pointOne: Point, val pointTwo: Point) {
    constructor(points: List<Point>) : this(points.first(), points.last())

    companion object {
        fun linify(stringLines: List<String>): List<Line> = stringLines.map{ l -> Line(l.split(" -> ").map{ p -> Point(p.split(',').map { i -> i.toInt()}) })}
    }

    val type: LINETYPE = when {
        pointOne.abscissa==pointTwo.abscissa
          && pointOne.ordinate==pointTwo.ordinate -> LINETYPE.Dot
        pointOne.abscissa==pointTwo.abscissa -> LINETYPE.Vertical
        pointOne.ordinate==pointTwo.ordinate -> LINETYPE.Horizontal
        else -> LINETYPE.Diagonal }
}

