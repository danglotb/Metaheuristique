package advancedsearch

import localsearch.AbstractLocalSearch
import solution.AbstractSolution
import model.AbstractModel
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness

trait AbstractAdvancedSearch[S <: AbstractSolution, M <: AbstractModel] {

  def apply(solution: S,
            model: M,
            intensification: AbstractLocalSearch[S, M],
            neighbors: AbstractNeighborsGenerator[S],
            diversification: AbstractNeighborsGenerator[S],
            fitness: AbstractFitness[S, M],
            currentFitness: Int): S

}