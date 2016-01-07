package solution.peinture

class EraseInstr(R: Int, C: Int) extends AbstractInstr(R,C){

  def apply(l : List[List[Boolean]]): List[List[Boolean]] = {
    List.fill(1, 1)(false)
  }

  override def toString = "ERASECELL " + r + " " + c + "\n"
  
}