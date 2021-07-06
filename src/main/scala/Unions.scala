// to run via bloop: `bloop run -w root -m unions`

type Id = "hello"           // singleton type

type Answer = "yes" | "no"  // union type

// do these types get 'erased at compile time'? think so.
// alternative to enums, less verbose, enum 'apparent at runtime'.

@main def unions: Unit = 
  val x: Answer = "no"
  println(x)

  val y: Answer = "yes"
  println(y)

  //val z: Answer = "wot?"  // compile error
