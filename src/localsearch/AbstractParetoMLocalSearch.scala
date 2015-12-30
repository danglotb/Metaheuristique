package localsearch

import solution.AbstractSolution
import model.AbstractModel
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractMFitness

trait AbstractParetoMLocalSearch[S <: AbstractSolution, M <: AbstractModel] {

  def apply(solutions: List[S],
            archives: List[S] = Nil,
            neighbors: AbstractNeighborsGenerator[S],
            fitness: AbstractMFitness[S, M]): List[S]

}