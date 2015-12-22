package filter

import solution.Permutation
import fitness.PermutationMTSPFitness
import model.MTSPModel

object PermutationMTSPFilter extends AbstractFilter[Permutation, MTSPModel] {

  override def apply(solutions : List[Permutation], model : MTSPModel) : List[Permutation] = {
    val scores = computeAllScores(solutions, model)
    solutions.filter { x => dominate(scores(solutions.indexOf(x)), scores.filter(s => s != scores(solutions.indexOf(x)))) }
  }
  
  private def computeAllScores(solutions : List[Permutation],
      model : MTSPModel,
      scores : List[List[Int]] = Nil, 
      index : Int = 0) : List[List[Int]] = {
    if(index == solutions.length)
      scores
    else
      computeAllScores(solutions, model,scores :+ PermutationMTSPFitness(solutions(index), model), index + 1)
  }
  
  private def dominate(score : List[Int], other : List[List[Int]]) : Boolean = {
    other.foreach { o =>
      for (i <- 0 until score.length)
        if (score(i) >= o(i))
          return false
    }
    true
  }

}