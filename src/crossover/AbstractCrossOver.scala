package crossover

import solution.AbstractSolution

trait AbstractCrossOver[S <: AbstractSolution] {
  
  def apply(parent1 : S, parent2 : S) : List[S]
  
  
}