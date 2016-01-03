package localsearch

import solution.AbstractSolution
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractMFitness
import model.AbstractModel

trait AbstractScalarMLocalSearch[S <: AbstractSolution, M <: AbstractModel] {

  val score = scala.collection.mutable.ListBuffer[Int]()

  def apply(solution: S,
            currentFitness: Int,
            model: M,
            neighbors: List[AbstractNeighborsGenerator[S]],
            listNeighbors: List[S],
            fitness: AbstractMFitness[S, M],
            currentRate: List[List[Double]],
            AcceptanceCriterion : () => Boolean,
            indexNeighbors: Int,
            paretoFront: List[S],
            currentRateIndex: Int): List[S]

}