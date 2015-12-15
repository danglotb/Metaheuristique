package advancedsearch

import solution.Permutation
import model.SMTWTPModel
import localsearch.BestSMTWTPSearch
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness
import localsearch.AbstractLocalSearch

object ILSSMTWTP extends AbstractAdvancedSearch[Permutation, SMTWTPModel] {

  override def apply(solution: Permutation,
                     model: SMTWTPModel,
                     intensification: AbstractLocalSearch[Permutation, SMTWTPModel],
                     neighbors: AbstractNeighborsGenerator[Permutation],
                     diversification: AbstractNeighborsGenerator[Permutation],
                     fitness: AbstractFitness[Permutation, SMTWTPModel],
                     currentFitness: Int): Permutation = solution

}