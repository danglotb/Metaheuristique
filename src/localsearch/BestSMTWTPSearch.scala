package localsearch

import solution.Permutation
import model.SMTWTPModel
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness

object BestSMTWTPSearch extends AbstractLocalSearch[Permutation, SMTWTPModel] {

  implicit override def apply(solution: Permutation,
                   currentFitness : Int,
                   model: SMTWTPModel,
                   neighbors: AbstractNeighborsGenerator[Permutation],
                   listNeighbors: List[Permutation],
                   fitness: AbstractFitness[Permutation, SMTWTPModel]): Permutation = {
    val bestNeighbor = listNeighbors.minBy { x => fitness(x, model) }
    val bestNeighborFitness = fitness(bestNeighbor, model)
    if (bestNeighborFitness < currentFitness)
      this(bestNeighbor, bestNeighborFitness, model, neighbors, neighbors(bestNeighbor), fitness)
    else
      solution
  }

}