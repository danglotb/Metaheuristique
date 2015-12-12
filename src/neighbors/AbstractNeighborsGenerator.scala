package neighbors

import solution.AbstractSolution
import solution.AbstractSolution

trait AbstractNeighborsGenerator[T <: AbstractSolution] {
  
  protected var cursorA = 0
  protected var cursorB = 0
  protected var lap = false
  protected var start : (Int,Int) = (-1,-1)
    
  protected def updateCursor(bound : Int) : Unit = {
    cursorB += 1
    if (cursorB == cursorA)
      cursorB += 1
    if (cursorB == bound) {
      cursorB = 0
      cursorA += 1
    }
    if (cursorA == bound)
        cursorA = 0
  }
  
  def reset() : Unit = start = (cursorA,cursorB)
  
  def hasDoneALap() : Boolean = {
    if (lap) {
      lap = false
      start = (-1,-1)
      return true
    } else
      return false
  }
  
  def neighbor(solution : T) : T;
  def neighbors(solution : T, start : (Int,Int) , list : List[T]) : List[T];
  
}