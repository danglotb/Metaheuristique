package vndsearch

import model.SMTWTPModel
import solution.Permutation
import fitness.AbstractFitness
import neighbors.AbstractNeighborsGenerator

object PipedVNDSMTWTPSearch extends AbstractVNDSearch[Permutation, SMTWTPModel] {

  def apply(solution: Permutation,
            currentFitness: Int,
            model: SMTWTPModel,
            neighbors: List[AbstractNeighborsGenerator[Permutation]],
            listNeighbors: List[Permutation],
            indexNeighbors: Int,
            fitness: AbstractFitness[Permutation, SMTWTPModel]): Permutation = {
    val neighbor = listNeighbors.minBy { x => fitness(x, model) }
    val fitnessNeighbor = fitness(neighbor, model)
    if (fitnessNeighbor < currentFitness) {
      if (indexNeighbors + 1 == neighbors.length)
        this(neighbor, fitnessNeighbor, model, neighbors, (neighbors(0)(neighbor)), 0, fitness)
      else
        this(neighbor, fitnessNeighbor, model, neighbors, (neighbors(indexNeighbors)(neighbor)), indexNeighbors, fitness)
    } else if (indexNeighbors + 1 == neighbors.length)
      solution
    else
      this(solution, currentFitness, model, neighbors, (neighbors(indexNeighbors + 1)(solution)), indexNeighbors + 1, fitness)
  }
}