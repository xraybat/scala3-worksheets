enum Colour:
  case Red(intensity: Double)
  case Green(emerald: Boolean = true)
  case Blue(seaLike: Boolean)

val col = Colour.Red(0.5d)
println(col)
