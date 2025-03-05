
object OpaqueType:
  opaque type FirstName = String
  opaque type LastName = String

  object FirstName:
    def apply(s: String): FirstName = s

  object LastName:
    def apply(s: String): LastName = s
end OpaqueType

import OpaqueType.*

@main def opaqueTypes: Unit = 
  println("hello")
  //uncommen t to test: def WontCompile(s: String): LastName = s
end opaqueTypes