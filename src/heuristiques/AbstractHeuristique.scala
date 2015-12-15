package heuristiques

import model.AbstractModel
import solution.AbstractSolution

trait AbstractHeuristique[M <: AbstractModel,S <: AbstractSolution] {
  
  def apply(model : M) : S
  
}