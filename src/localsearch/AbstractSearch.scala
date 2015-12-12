package localsearch

import solution.AbstractSolution
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness
import model.AbstractModel

trait AbstractSearch[S <: AbstractSolution, M <: AbstractModel] {
  
  def run(solution : S, model : M, neighbors : AbstractNeighborsGenerator[S], fitness : AbstractFitness[S,M]) : S
  
}