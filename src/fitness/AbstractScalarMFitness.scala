package fitness

import solution.AbstractSolution
import model.AbstractModel

trait AbstractScalarMFitness[S <: AbstractSolution, M <: AbstractModel] {

  def apply(fitness: AbstractMFitness[S, M],
            rate: List[Double],
            solution: S,
            model: M): Int

}