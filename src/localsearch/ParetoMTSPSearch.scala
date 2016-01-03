package localsearch

import model.MTSPModel
import solution.Permutation
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractMFitness

object ParetoMTSPSearch extends AbstractParetoMLocalSearch[Permutation, MTSPModel] {

  var nbRun = 0
  
  def apply(model: MTSPModel,
            solutions: List[Permutation],
            neighbors: AbstractNeighborsGenerator[Permutation],
            acceptanceCriterion : () => Boolean,
            archives: List[Permutation] = Nil) : List[Permutation] = {
    if (acceptanceCriterion())
      archives
    else {
      nbRun += 1
      println(nbRun)
      val betterNeighbors = filter.PermutationMTSPFilter(neighbors(solutions.head):+solutions.head, model)
      this(model, solutions.tail ++ betterNeighbors,neighbors,acceptanceCriterion,archives++betterNeighbors)
    }
  }

}