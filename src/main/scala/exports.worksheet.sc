sealed trait CoordSvc(x: Int, y: Int)
case class Coord(val x: Int, val y: Int) extends CoordSvc(x, y)
object Coord:
  def apply(x:Int, y:Int): Coord =
    require(x >= -100 && x <= 100)
    require(y >= -100 && y <= 100)
    new Coord(x, y)

//val c = Coord(-101, 99)   // exception

case class X(c: Coord):
  override def toString = s"X($x)"
  export c.{ y as _, * }

case class Y(c: Coord):
  override def toString = s"Y($y)"
  export c.{ x as _, * }

case class XY(c: Coord):
  override def toString = s"XY($x, $y)"
  export c.*

val x = X(Coord(1, 0)) 
println("x: " + x)
//printf("x: %d\n", x.y)   // error

val y = Y(Coord(0, 2)) 
println("y: " + y)
//printf("y: %d\n", y.x)   // error

val xy = XY(Coord(3, 4))
println("xy: " + xy)
