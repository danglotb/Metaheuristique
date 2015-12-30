package advancedsearch

import solution.Permutation
import model.SMTWTPModel
import localsearch.BestSMTWTPSearch
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness
import localsearch.AbstractLocalSearch

object ILSSMTWTP extends AbstractAdvancedSearch[Permutation, SMTWTPModel] {
  
  var currentFitnessG : Int = Integer.MAX_VALUE
  
  var bestPermutation : Permutation = _
  var bestFitness : Int = Integer.MAX_VALUE
  
  private def repeatDiversification(couples: IndexedSeq[(Int, Int)],
                                    diversification: AbstractNeighborsGenerator[Permutation],                                 
                                    solution: Permutation): Permutation = {
    if (couples isEmpty)
      solution
    else
      repeatDiversification(couples.tail,
        diversification,
        diversification(solution, couples.head._1, couples.head._2))
  }

  override def apply(solution: Permutation,
                     model: SMTWTPModel,
                     intensification: AbstractLocalSearch[Permutation, SMTWTPModel],
                     neighbors: List[AbstractNeighborsGenerator[Permutation]],
                     diversification: AbstractNeighborsGenerator[Permutation],
                     fitness: AbstractFitness[Permutation, SMTWTPModel],
                     currentFitness: Int,
                     acceptanceCriterion: (() => Boolean)): Permutation = {
    if (acceptanceCriterion())
      bestPermutation
    else {
      val indices = solution.permutation.indices
      val tails = indices.tail map (i => indices drop i)
      val couples = scala.util.Random.shuffle((indices zip tails) flatMap (c => c._2 map (i => (c._1, i))))
      val divers = repeatDiversification(couples.dropRight(new java.util.Random().nextInt(9)+3), diversification , solution)
      val intens = intensification(divers, currentFitness, model, neighbors, (neighbors(0)(solution)), fitness, 0)
      currentFitnessG = fitness(intens, model)
      if (currentFitnessG < bestFitness) {
        bestPermutation = intens
        bestFitness = currentFitnessG
      }
      this(intens, model, intensification, neighbors, diversification, fitness, currentFitnessG , acceptanceCriterion)
    }
  }
  
}