package localsearch

import solution.Permutation
import model.MTSPModel
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractMFitness
import fitness.PermutationScalarMTSPFitness
import heuristiques.MTSPRandomHeuristique

object BestScalarMTSPSearch extends AbstractScalarMLocalSearch[Permutation, MTSPModel] {

  def apply(currentSolution: Permutation,
            currentFitness: Int,
            model: MTSPModel,
            neighbors: List[AbstractNeighborsGenerator[Permutation]],
            listNeighbors: List[Permutation],
            fitness: AbstractMFitness[Permutation, MTSPModel],
            currentRate: List[List[Double]],
            AcceptanceCriterion: () => Boolean,
            indexNeighbors: Int = 0,
            paretoFront: List[Permutation] = Nil,
            currentRateIndex: Int = 0): List[Permutation] = {
    if (currentRateIndex == currentRate.length || AcceptanceCriterion())
      paretoFront
    else {
      val bestNeighbors = listNeighbors.minBy { x => PermutationScalarMTSPFitness(fitness, currentRate(currentRateIndex), x, model) }
      val newFitness = PermutationScalarMTSPFitness(fitness, currentRate(currentRateIndex), bestNeighbors, model)
      if (newFitness < currentFitness)
        this(bestNeighbors, newFitness, model, neighbors, neighbors(0)(bestNeighbors), fitness,
          currentRate, AcceptanceCriterion, 0, paretoFront, currentRateIndex)
      else {
        println(currentRateIndex + 1 + " / " + currentRate.length)
        this(bestNeighbors, currentFitness, model, neighbors, neighbors(0)(bestNeighbors), fitness,
          currentRate, AcceptanceCriterion, 0, paretoFront :+ currentSolution, currentRateIndex + 1)
      }
    }
  }

}