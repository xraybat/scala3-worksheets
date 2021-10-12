// to run via bloop: `bloop run -w worksheets -m unionsErrors`
// to find main classes: `bloop autocomplete --mode=mainsfqcn --project=worksheets
//                          --format=bash com.sourcegraph.lsif_java.LsifJava`

enum Error1:
  case Code1, Code2, Code3
end Error1

enum Error2:
  case Code4, Code5, Code6
end Error2

def service1: Either[Error1, String] = { println("service1"); Left(Error1.Code3) }
def service2: Either[Error2, String] = { println("service2"); Left(Error2.Code4) }

def program1: Either[Error1, String] = 
  for
    result1 <- service1
  yield 
    s"program1: $result1"
end program1

def program1and2: Either[Error1 | Error2, String] = 
  for
    result1 <- service1
    result2 <- service2
  yield
    s"program1and2: result1, $result1; result2, $result2"

end program1and2

def combine1and2 =  // `Either[Error1 | Error2, String]` will be inferred
  for
    prog1 <- program1
    prog1and2 <- program1and2
  yield
    s"combine1and2: program1, $prog1; program1and2, $prog1and2"
end combine1and2

def combineAll =    // `Either[Error1 | Error2, String]` will be inferred
  for
    prog1 <- program1
    prog1and2 <- program1and2
  yield
    s"combineAll: program1, $prog1; program1and2, $prog1and2"
end combineAll

@main def unionsErrors: Unit = 
  println("==="
    + s"\nprogram1: $program1"
    + s"\nprogram1and2: $program1and2"
    + s"\ncombineAll: $combineAll"
    + "\n===\n")

  program1and2 match  // QU??: warning here??
    case Right(value: String) => println(value)
    case Left(err: Error1) => println(err)
    case Left(err: Error2) => println(err)  // commenting this out would lead to compile error 'match may not be exhaustive'

  combine1and2 match  // note the union gets inferred to `Either[Error1 | Error2, String]` (from program1and2), not just `Either[Error1, String` from program1
    case Right(value: String) => println(value)
    case Left(err: Error1) => println(err)
    case Left(err: Error2) => println(err)  // commenting this out would lead to compile error 'match may not be exhaustive'

  combineAll match
    case Right(value: String) => println(value)
    case Left(err: Error1) => println(err)
    case Left(err: Error2) => println(err)  // commenting this out would lead to compile error 'match may not be exhaustive'

  println("scala3 got here!")

end unionsErrors
