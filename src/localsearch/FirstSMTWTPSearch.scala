package localsearch

import solution.Permutation
import neighbors.AbstractNeighborsGenerator
import model.SMTWTPModel
import fitness.AbstractFitness

object FirstSMTWTPSearch extends AbstractLocalSearch[Permutation, SMTWTPModel] {

  override def apply(solution: Permutation,
                   currentFitness: Int,
                   model: SMTWTPModel,
                   neighbors: List[AbstractNeighborsGenerator[Permutation]],
                   listNeighbors: List[Permutation],
                   fitness: AbstractFitness[Permutation, SMTWTPModel],
                   currentNeighbor : Int = 0): Permutation = {
    if (listNeighbors isEmpty)
      return solution

    val newNeighbor = listNeighbors.head
    val newFitness = fitness(newNeighbor, model)
    if (newFitness < currentFitness)
      this(newNeighbor, newFitness, model, neighbors, neighbors(0)(newNeighbor), fitness)
    else
      this(solution, currentFitness, model, neighbors, listNeighbors.tail, fitness)
  }
}