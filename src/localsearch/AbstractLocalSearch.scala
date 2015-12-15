package localsearch

import solution.AbstractSolution
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness
import model.AbstractModel

trait AbstractLocalSearch[S <: AbstractSolution, M <: AbstractModel] {
  
  implicit def apply(solution : S,
      currentFitness : Int,
      model : M, 
      neighbors : AbstractNeighborsGenerator[S],
      listNeighbors: List[S],
      fitness : AbstractFitness[S,M]) : S
  
}