package solution.peinture

abstract class AbstractInstr(R : Int, C : Int) {
  
  def apply(l : List[List[Boolean]]) : List[List[Boolean]]
  
  def r = R
  def c = C
  
}