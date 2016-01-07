package solution.peinture

import solution.AbstractSolution

class Instructions(instr : List[AbstractInstr]) extends AbstractSolution {
  
  def length() = instr.length
  
  def eval : List[List[Boolean]] = {
    Nil
  }
  
  def equals(other : Instructions) = eval == other.eval
  
  override def toString = instr.foldLeft(""){case (acc,i) => acc + i.toString}
  
}