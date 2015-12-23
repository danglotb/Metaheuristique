package fitness

import solution.Permutation
import model.MTSPModel

object PermutationScalarMTSPFitness extends AbstractScalarMFitness[Permutation, MTSPModel] {

  override def apply(fitness: AbstractMFitness[Permutation, MTSPModel],
            rate: List[Double],
            solution: Permutation,
            model: MTSPModel): Int = {
    val fitnesses = fitness(solution, model)
    rate.foldLeft(0.0) {
      case (acc, r) => acc + (r * fitnesses(rate.indexOf(r)))
    }.toInt
  }

}