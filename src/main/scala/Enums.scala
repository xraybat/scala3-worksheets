// to run via bloop: `bloop run -w worksheets -m enums`

enum Colour:
  case Red(intensity: Double)
  case Green(emerald: Boolean = true)
  case Blue(seaLike: Boolean)

@main def enums: Unit = 
  val col1 = Colour.Red(0.5d)
  val col2 = Colour.Green
  val col3 = Colour.Blue(true)
  println(s"$col1, $col2, $col3")
