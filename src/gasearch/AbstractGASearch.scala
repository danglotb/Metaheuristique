package gasearch

import solution.AbstractSolution
import model.AbstractModel
import crossover.AbstractCrossOver
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness

trait AbstractGASearch[S <: AbstractSolution, M <: AbstractModel] {

  def apply(model: M,
            population: List[S],
            crossover: AbstractCrossOver[S],
            mutation: AbstractNeighborsGenerator[S],
            probaMutation : Float,
            numberGene : Int,
            fitness : AbstractFitness[S,M],
            currentGene : Int): List[S]

}