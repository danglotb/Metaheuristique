package fitness

import solution.Permutation
import model.MTSPModel

object PermutationMTSPFitness extends AbstractMFitness[Permutation, MTSPModel] {

  override def apply(solution: Permutation, model: MTSPModel) : List[Int] = compute(solution, model)

  private def compute(solution: Permutation,
                      model: MTSPModel,
                      scores: List[Int] = Nil,
                      index: Int = 0): List[Int] = {
    if (index == solution.size - 1) {
      for (i <- 0 until model.nbObjectifs) {
        scores.updated(i, scores(i) + model(i, solution(index), solution(1)))
      }
      scores
    } else {
      for (i <- 0 until model.nbObjectifs) {
        scores.updated(i, scores(i) + model(i, solution(index), solution(index + 1)))
      }
    }
    compute(solution, model, scores, index + 1)
  }

}