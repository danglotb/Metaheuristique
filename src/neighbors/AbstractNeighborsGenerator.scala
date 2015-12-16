package neighbors

import solution.AbstractSolution
import solution.AbstractSolution

trait AbstractNeighborsGenerator[S <: AbstractSolution] {

  def apply(solution: S, i: Int, j: Int): S

  def apply(solution: S): List[S]

}