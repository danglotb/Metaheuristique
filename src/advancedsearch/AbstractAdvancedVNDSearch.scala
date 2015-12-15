package advancedsearch

import localsearch.AbstractLocalSearch
import solution.AbstractSolution
import model.AbstractModel
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness
import vndsearch.AbstractVNDSearch

trait AbstractAdvancedVNDSearch[S <: AbstractSolution, 
                             M <: AbstractModel,
                             I <: AbstractVNDSearch[S, M],
                             N <: AbstractNeighborsGenerator[S],
                             F <: AbstractFitness[S, M]] {
  
    def apply(solution : S,
              model : M,
              intensification : I,
              neighbors : N,
              diversification : N,
              fitness : F,
              currentFitness : Int) : S
  
  
  
  
  
}