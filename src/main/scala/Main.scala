// to run via bloop: `bloop run -w worksheets -m hello`

@main def hello: Unit = 
  println("hello, world!")
  println(msg)

def msg = "i was compiled by scala 3. :) "
