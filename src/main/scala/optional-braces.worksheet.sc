trait Controversial:
  def hello(s: String) = 
    s match
      case "hello" => if true then println(s) else println("nope!")
      case _ => println("nope!")
//end Controversial // causes worksheet (only) syntax error...

class Doit extends Controversial

// scala3 now allows top level definitions (don't need to wrap in object)
type Hello = String
def topHello: Hello = topMsg
val topMsg: Hello = "(top)hello"

val c = new Doit
c.hello("hello")
c.hello("bye")

println(topHello)