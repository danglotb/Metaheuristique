package gasearch

import solution.AbstractSolution
import model.AbstractModel
import fitness.AbstractFitness
import crossover.AbstractCrossOver
import neighbors.AbstractNeighborsGenerator
import localsearch.AbstractLocalSearch

trait AbstractMASearch[S <: AbstractSolution, M <: AbstractModel] {

  def apply(model: M,
            fitness: AbstractFitness[S, M],
            population: List[S],
            crossover: AbstractCrossOver[S],
            crossoverRate: Float,
            mutation: AbstractNeighborsGenerator[S],
            mutationRate: Float,
            localSearch: AbstractLocalSearch[S, M],
            localSearchNeighbors: List[AbstractNeighborsGenerator[S]],
            criterionAcceptance: (() => Boolean)): List[S]

}