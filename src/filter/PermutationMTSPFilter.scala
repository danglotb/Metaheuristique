package filter

import solution.Permutation
import fitness.PermutationMTSPFitness
import model.MTSPModel

object PermutationMTSPFilter extends AbstractFilter[Permutation, MTSPModel] {

  var nbComparaison : Int = 0
  
  override def apply(solutions: List[Permutation], model: MTSPModel): List[Permutation] = {

    val scores = PermutationMTSPFitness.computeAllScores(solutions, model)

    val dominated = solutions.filter { x =>
      val others = scores.diff(List(scores(solutions.indexOf(x))))
      isDominated(scores(solutions.indexOf(x)), others)
    }
    solutions.diff(dominated)
  }

  private def isDominated(score: List[Int], other: List[List[Int]]): Boolean = {
    other.foreach { o =>
      var b = true
      for (i <- 0 until score.length) {
        nbComparaison += 1
        b &= score(i) > o(i)
      }
      if (b)
        return b
    }
    false
  }
  
  def buildRandomInstance(model: MTSPModel, nbInstance: Int = 500, list: List[Permutation] = Nil): List[Permutation] = {
    if (list.size == nbInstance)
      list
    else
      buildRandomInstance(model, nbInstance, list :+ heuristiques.MTSPRandomHeuristique(model))
  }

  def buildRandomInstanceFilterOnLine(model: MTSPModel,
                                      i: Int = 0,
                                      nbInstance: Int = 500,
                                      list: List[Permutation] = Nil): List[Permutation] = {
    if (i == nbInstance)
      list
    else {
      buildRandomInstanceFilterOnLine(model, i + 1, nbInstance, PermutationMTSPFilter((list :+ heuristiques.MTSPRandomHeuristique(model)), model))
    }
  }

}