package heuristiques

import model.AbstractModel
import solution.AbstractSolution

trait AbstractHeuristique[M <: AbstractModel,S <: AbstractSolution] {
  
  def buildHeuristique(model : M) : S
  
}