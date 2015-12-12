package neighbors

import solution.Permutation

object PermutationSwap extends AbstractNeighborsGenerator[Permutation] {
  
  override def neighbor(solution : Permutation) : Permutation = {
    if (start == (-1,-1))
        reset
    val newPermutation = solution.Solution
    val tmp = newPermutation(cursorA)
    newPermutation(cursorA) = newPermutation(cursorB)
    newPermutation(cursorB) = tmp
    updateCursor(solution.Solution.length)
    if ( (cursorA,cursorB) == start) lap = true
    new Permutation(newPermutation)
  }
  
  override def neighbors(solution : Permutation, start : (Int,Int) = (cursorA, cursorB), 
      list : List[Permutation] = Nil) : List[Permutation] = {
      if ( (cursorA,cursorB) == start && list.length > 0)
        list
      else
        neighbors(solution, start, list :+ neighbor(solution))
  }
  
}