package localsearch

import solution.Permutation
import neighbors.AbstractNeighborsGenerator
import model.SMTWTPModel
import fitness.AbstractFitness

object FirstSMTWTPSearch extends AbstractLocalSearch[Permutation, SMTWTPModel] {

  implicit override def apply(solution: Permutation,
                   currentFitness: Int,
                   model: SMTWTPModel,
                   neighbors: AbstractNeighborsGenerator[Permutation],
                   listNeighbors: List[Permutation],
                   fitness: AbstractFitness[Permutation, SMTWTPModel]): Permutation = {
    if (listNeighbors isEmpty)
      return solution

    val newNeighbor = listNeighbors.head
    val newFitness = fitness(newNeighbor, model)
    if (newFitness < currentFitness)
      this(newNeighbor, newFitness, model, neighbors, neighbors(newNeighbor), fitness)
    else
      this(solution, currentFitness, model, neighbors, listNeighbors.tail, fitness)
  }
}