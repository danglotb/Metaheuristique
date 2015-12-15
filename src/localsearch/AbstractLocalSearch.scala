package localsearch

import solution.AbstractSolution
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness
import model.AbstractModel

trait AbstractLocalSearch[S <: AbstractSolution, M <: AbstractModel] {
  
  def run(solution : S,
      currentFitness : Int,
      model : M, 
      neighbors : AbstractNeighborsGenerator[S],
      listNeighbors: List[S],
      fitness : AbstractFitness[S,M]) : S
  
}