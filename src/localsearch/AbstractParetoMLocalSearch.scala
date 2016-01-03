package localsearch

import solution.AbstractSolution
import model.AbstractModel
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractMFitness

trait AbstractParetoMLocalSearch[S <: AbstractSolution, M <: AbstractModel] {

  def apply(model: M,
            solutions: List[S],
            neighbors: AbstractNeighborsGenerator[S],
            acceptanceCriterion: () => Boolean,
            archives: List[S]): List[S]

}