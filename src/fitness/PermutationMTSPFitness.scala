package fitness

import solution.Permutation
import model.MTSPModel

object PermutationMTSPFitness extends AbstractMFitness[Permutation, MTSPModel] {

  override def apply(solution: Permutation, model: MTSPModel): List[Int] = compute(solution, model, List.fill(model.nbObjectifs)(0))

  private def compute(solution: Permutation,
                      model: MTSPModel,
                      scores: List[Int],
                      index: Int = 0): List[Int] = {
    if (index == solution.size - 1)
      updateLast(scores, index, model, solution)
    else
      compute(solution, model, update(scores, index, model, solution), index + 1)
  }

  private def update(scores: List[Int],
                     index: Int, model: MTSPModel,
                     solution: Permutation, i: Int = 0): List[Int] = {
    if (i == model.nbObjectifs)
      scores
    else
      update(scores.updated(i, scores(i) + model(i, solution(index), solution(index + 1))),
        index, model, solution, i + 1)
  }

  private def updateLast(scores: List[Int],
                         index: Int, model: MTSPModel,
                         solution: Permutation, i: Int = 0): List[Int] = {
    if (i == model.nbObjectifs)
      scores
    else
      updateLast(scores.updated(i, scores(i) + model(i, solution(index), solution(1))),
        index, model, solution, i + 1)
  }

}