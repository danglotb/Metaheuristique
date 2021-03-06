package solution.peinture

class EraseInstr(R: Int, C: Int) extends AbstractInstr(R,C){

  def apply(l : List[List[Boolean]]): List[List[Boolean]] = l.updated(R,l(R).updated(C, false))

  override def toString = "ERASECELL " + r + " " + c + "\n"
  
}