package solution.peinture

class PaintInstr(R : Int, C : Int, S : Int) extends AbstractInstr(R,C){
  
  def s = S
  
  override def apply(l : List[List[Boolean]]) : List[List[Boolean]] = {
    List.fill(2*S+1,2*S+1)(true)
  }
  
  override def toString = "PAINTSQ " + r + " " + c + " " + s + "\n" 
  
}