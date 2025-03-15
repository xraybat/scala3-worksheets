trait CoordSvc(x: Int, y: Int)
class Coord(val x: Int, val y: Int) extends CoordSvc(x, y)

class X(coord: Coord):
  export coord.{ y as _, * }

class Y(coord: Coord):
  export coord.{ x as _, * }

class XY(coord: Coord):
  export coord.*

val x = new X(Coord(1, 0)) 
printf("x: %d\n", x.x)
//printf("x: %d\n", x.cy)   // error

val y = new Y(Coord(0, 2)) 
printf("y: %d\n", y.y)
//printf("y: %d\n", y.cx)   // error

val xy = new XY(Coord(3, 4))
printf("xy: (%d, %d)\n", xy.x, xy.y)
