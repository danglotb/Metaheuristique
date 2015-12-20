package localsearch

import model.SMTWTPModel
import solution.Permutation
import fitness.AbstractFitness
import neighbors.AbstractNeighborsGenerator

object PipedVNDSMTWTPSearch extends AbstractLocalSearch[Permutation, SMTWTPModel] {

  override def apply(solution: Permutation,
            currentFitness: Int,
            model: SMTWTPModel,
            neighbors: List[AbstractNeighborsGenerator[Permutation]],
            listNeighbors: List[Permutation],
            fitness: AbstractFitness[Permutation, SMTWTPModel],
            indexNeighbors: Int): Permutation = {
    val neighbor = listNeighbors.minBy { x => fitness(x, model) }
    val fitnessNeighbor = fitness(neighbor, model)
    if (fitnessNeighbor < currentFitness) {
      if (indexNeighbors + 1 == neighbors.length)
        this(neighbor, fitnessNeighbor, model, neighbors, (neighbors(0)(neighbor)), fitness, 0)
      else
        this(neighbor, fitnessNeighbor, model, neighbors, (neighbors(indexNeighbors)(neighbor)), fitness, indexNeighbors)
    } else if (indexNeighbors + 1 == neighbors.length)
      solution
    else
      this(solution, currentFitness, model, neighbors, (neighbors(indexNeighbors + 1)(solution)), fitness, indexNeighbors + 1)
  }
  
  override def toString() : String = "pipedvnd"
}