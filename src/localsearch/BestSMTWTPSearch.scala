package localsearch

import solution.Permutation
import model.SMTWTPModel
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness

object BestSMTWTPSearch extends AbstractLocalSearch[Permutation, SMTWTPModel] {

  override def apply(solution: Permutation,
                     currentFitness: Int,
                     model: SMTWTPModel,
                     neighbors: List[AbstractNeighborsGenerator[Permutation]],
                     listNeighbors: List[Permutation],
                     fitness: AbstractFitness[Permutation, SMTWTPModel],
                     indexNeighbor: Int = 0): Permutation = {
    val bestNeighbor = listNeighbors.minBy { x => fitness(x, model) }
    val bestNeighborFitness = fitness(bestNeighbor, model)
    if (bestNeighborFitness < currentFitness) {
      score += bestNeighborFitness
      this(bestNeighbor, bestNeighborFitness, model, neighbors, (neighbors(indexNeighbor)(bestNeighbor)), fitness)
    } else
      solution
  }

  override def toString() : String = "best"
  
}