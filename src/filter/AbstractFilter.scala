package filter

import solution.AbstractSolution
import model.AbstractModel

trait AbstractFilter[S <: AbstractSolution, M <: AbstractModel] {

  def apply(scores : List[S], model : M) : List[S]
  
}