trait CoordSvc(x: Int, y: Int)
class Coord(val x: Int, val y: Int) extends CoordSvc(x, y)

class X(c: Coord):
  export c.{ y as _, * }

class Y(c: Coord):
  export c.{ x as _, * }

class XY(c: Coord):
  export c.*

val x = X(Coord(1, 0)) 
printf("x: %d\n", x.x)
//printf("x: %d\n", x.y)   // error

val y = Y(Coord(0, 2)) 
printf("y: %d\n", y.y)
//printf("y: %d\n", y.x)   // error

val xy = XY(Coord(3, 4))
printf("xy: (%d, %d)\n", xy.x, xy.y)
