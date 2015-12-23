package localsearch

import solution.Permutation
import model.MTSPModel
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractMFitness
import fitness.PermutationScalarMTSPFitness

object ScalarMTSPSearch extends AbstractScalarMLocalSearch[Permutation, MTSPModel] {

  def apply(currentSolution: Permutation,
            currentFitness: Int,
            model: MTSPModel,
            neighbors: List[AbstractNeighborsGenerator[Permutation]],
            listNeighbors: List[Permutation],
            fitness: AbstractMFitness[Permutation, MTSPModel],
            indexNeighbors: Int = 0,
            paretoFront: List[Permutation] = Nil,
            currentRate: List[Double] = List(0.1, 0.9)): List[Permutation] = {
    if (listNeighbors.isEmpty) {
      if (currentRate == List(0.9, 0.1))
        paretoFront
      else
        this(currentSolution, currentFitness, model, neighbors, neighbors(0)(currentSolution), fitness, 0,
          paretoFront :+ currentSolution, currentRate.updated(0, currentRate(0) + 0.1).updated(1, currentRate(1) - 0.1))
    } else {
      val newNeighbors = listNeighbors.head
      val newFitness = PermutationScalarMTSPFitness(fitness, currentRate, newNeighbors, model)
      if (newFitness < currentFitness)
        this(newNeighbors, newFitness, model, neighbors, neighbors(0)(newNeighbors), fitness, 0, paretoFront, currentRate)
      else
        this(currentSolution, currentFitness, model, neighbors, listNeighbors.tail, fitness, 0, paretoFront, currentRate)
    }
  }

}