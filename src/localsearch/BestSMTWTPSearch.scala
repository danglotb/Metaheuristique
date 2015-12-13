package localsearch

import solution.Permutation
import model.SMTWTPModel
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness

object BestSMTWTPSearch extends AbstractSearch[Permutation, SMTWTPModel] {

  override def run(solution: Permutation,
                   currentFitness : Int,
                   model: SMTWTPModel,
                   neighbors: AbstractNeighborsGenerator[Permutation],
                   listNeighbors: List[Permutation],
                   fitness: AbstractFitness[Permutation, SMTWTPModel]): Permutation = {
    val bestNeighbor = listNeighbors.minBy { x => fitness(x, model) }
    val bestNeighborFitness = fitness(bestNeighbor, model)
    if (bestNeighborFitness < currentFitness)
      run(bestNeighbor, bestNeighborFitness, model, neighbors, neighbors(bestNeighbor), fitness)
    else
      solution
  }

}