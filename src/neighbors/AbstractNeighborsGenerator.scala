package neighbors

import solution.AbstractSolution
import solution.AbstractSolution

trait AbstractNeighborsGenerator[T <: AbstractSolution] {
  
   def apply(solution: T): List[T]
    
}