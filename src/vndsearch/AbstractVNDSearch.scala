package vndsearch

import solution.AbstractSolution
import model.AbstractModel
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness

/**
 * @author danglot
 */
trait AbstractVNDSearch[S <: AbstractSolution, M <: AbstractModel] {
  
  def apply(solution : S,
      currentFitness : Int,
      model : M, 
      neighbors : List[AbstractNeighborsGenerator[S]],
      listNeighbors : List[S],
      indexNeighbors : Int,
      fitness : AbstractFitness[S,M]) : S
  
}