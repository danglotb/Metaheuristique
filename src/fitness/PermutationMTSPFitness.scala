package fitness

import solution.Permutation
import model.MTSPModel

object PermutationMTSPFitness extends AbstractMFitness[Permutation, MTSPModel] {

  override def apply(solution: Permutation, model: MTSPModel): List[Int] = {
    counter += 1
    compute(solution, model, List.fill(model.nbObjectifs)(0))
  }

  def computeAllScores(solutions: List[Permutation],
                       model: MTSPModel,
                       scores: List[List[Int]] = Nil,
                       index: Int = 0): List[List[Int]] = {
    if (index == solutions.length)
      scores
    else
      computeAllScores(solutions, model, scores :+ this(solutions(index), model), index + 1)
  }

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
                     solution: Permutation,
                     i: Int = 0): List[Int] = {
    if (i == model.nbObjectifs)
      scores
    else {
      val min = math.min(solution(index), solution(index + 1))
      val max = math.max(solution(index), solution(index + 1))
      update(scores.updated(i, scores(i) + model(i, min, max)),
        index, model, solution, i + 1)
    }
  }

  private def updateLast(scores: List[Int],
                         index: Int, model: MTSPModel,
                         solution: Permutation, i: Int = 0): List[Int] = {
    if (i == model.nbObjectifs) 
      scores
    else {
      val min = math.min(solution(index), solution(0))
      val max = math.max(solution(index), solution(0))
      updateLast(scores.updated(i, scores(i) +  model(i, min, max)),
        index, model, solution, i + 1)
    }

  }

}