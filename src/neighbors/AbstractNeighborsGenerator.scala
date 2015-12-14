package neighbors

import solution.AbstractSolution
import solution.AbstractSolution

trait AbstractNeighborsGenerator[T <: AbstractSolution] {
  
    implicit def apply(solution: T): List[T]
    
    implicit def apply(solution : T, i : Int, j : Int) : T
}