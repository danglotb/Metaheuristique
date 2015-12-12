package localsearch

import solution.Permutation
import neighbors.AbstractNeighborsGenerator
import model.SMTWTPModel
import fitness.AbstractFitness

object FirstSMTWTPSearch extends AbstractSearch[Permutation, SMTWTPModel] {

  override def run(solution: Permutation, model: SMTWTPModel,
                   neighbors: AbstractNeighborsGenerator[Permutation],
                   fitness: AbstractFitness[Permutation, SMTWTPModel]): Permutation = {
    if (neighbors hasDoneALap)
      return solution
    val newSolution = neighbors.neighbor(solution)
    if (fitness.compute(newSolution, model) >= fitness.compute(solution, model)) {
      run(solution, model, neighbors, fitness)
    } else {
      neighbors.reset
      run(newSolution, model, neighbors, fitness)
    }
  }
}