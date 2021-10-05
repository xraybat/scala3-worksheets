// to run via bloop: `bloop run -w worksheets -m unionsErrors`
// to find main classes: `bloop autocomplete --mode=mainsfqcn --project=worksheets
//                          --format=bash com.sourcegraph.lsif_java.LsifJava`

enum Error1:
  case Code1, Code2, Code3
end Error1

enum Error2:
  case Code4, Code5, Code6
end Error2

def service1: Either[Error1, String] = Left(Error1.Code3)
def service2: Either[Error2, String] = Left(Error2.Code4)

def program1: Either[Error1, String] = 
  for
    result1 <- service1
  yield 
    s"hello1, $result1"
end program1

def program2: Either[Error1 | Error2, String] = 
  for
    result1 <- service1
    result2 <- service2
  yield 
    s"hello2, $result1, $result2"
end program2

def combine = 
  for
    prog1 <- program1
    prog2 <- program2
  yield
    s"combine, $prog1, $prog2"
end combine

@main def unionsErrors: Unit = 
  program2 match                  // QU??: warning here??
    case Right(value: String) => ()
    case Left(err: Error1) => ()
    case Left(err: Error2) => ()  // commenting this out would lead to compile error 'match may not be exhaustive'

  combine match // note the union gets inferred to `Either[Error1 | Error2, String]` (from program2), not just `Either[Error1, String` from program1
    case Right(value: String) => ()
    case Left(err: Error1) => ()
    case Left(err: Error2) => ()  // commenting this out would lead to compile error 'match may not be exhaustive'

  println("scala3 got here!")

end unionsErrors
