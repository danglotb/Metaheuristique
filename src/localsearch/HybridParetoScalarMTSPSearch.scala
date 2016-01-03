package localsearch

import model.MTSPModel
import solution.Permutation
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractMFitness

object HybridParetoScalarMTSPSearch extends AbstractParetoMLocalSearch[Permutation,MTSPModel]{

  var nbRun = 0

  def apply(model: MTSPModel,
            solutions: List[Permutation],
            neighbors: AbstractNeighborsGenerator[Permutation],
            acceptanceCriterion: () => Boolean,
            archives: List[Permutation] = Nil): List[Permutation] = {
    
    if (acceptanceCriterion())
      archives
    else {
      
      println(nbRun)
      
      val weights = fitness.PermutationScalarMTSPFitness.buildWeigth2D(0.0, 4000.0, 40)
      
      val firstFitness = fitness.PermutationScalarMTSPFitness(
        fitness.PermutationMTSPFitness,
        weights.head,
        solutions.head,
        model)

        println("scalar now with : " + weights)
        
      val scalar = BestScalarMTSPSearch(solutions.head,
        firstFitness,
        model,
        List(neighbors),
        neighbors(solutions.head),
        fitness.PermutationMTSPFitness,
        weights,
        acceptanceCriterion)
        
      val betterNeighbors = filter.PermutationMTSPFilter( (neighbors(solutions.head) :+ solutions.head) ++ scalar , model)
      
      nbRun += 1
      
      this(model, solutions.tail ++ betterNeighbors, neighbors, acceptanceCriterion, archives ++ betterNeighbors)
    }
  }

}