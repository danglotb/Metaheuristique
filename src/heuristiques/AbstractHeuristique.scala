package heuristiques

import model.AbstractModel
import solution.AbstractSolution

trait AbstractHeuristique[M <: AbstractModel,S <: AbstractSolution] {
  
  implicit def apply(model : M) : S
  
}