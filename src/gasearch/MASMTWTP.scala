package gasearch

import model.SMTWTPModel
import solution.Permutation
import fitness.AbstractFitness
import crossover.AbstractCrossOver
import neighbors.AbstractNeighborsGenerator
import localsearch.AbstractLocalSearch

object MASMTWTP extends AbstractMASearch[Permutation, SMTWTPModel] {

  def apply(model: SMTWTPModel,
            fitness: AbstractFitness[Permutation, SMTWTPModel],
            population: List[Permutation],
            crossover: AbstractCrossOver[Permutation],
            crossoverRate: Float,
            mutationInner: AbstractNeighborsGenerator[Permutation],
            mutationRate: Float,
            localSearch: AbstractLocalSearch[Permutation, SMTWTPModel],
            localSearchNeighbors: List[AbstractNeighborsGenerator[Permutation]],
            criterionAcceptance: (() => Boolean)): List[Permutation] = {
    if (criterionAcceptance())
      population
    else {
      val indices = population.indices
      val tails = indices.tail map (i => indices drop i)
      val couples = scala.util.Random.shuffle((indices zip tails) flatMap (c => c._2 map (i => (c._1, i))))

      val children = crossOver(population, crossover, (couples.dropRight((population.size * crossoverRate).toInt).toList))

      val mutant = mutation(children, mutationInner, mutationRate)

      val newPopulation = (mutant.map(m => localSearch(m,
        fitness(m, model),
        model,
        localSearchNeighbors,
        localSearchNeighbors(0)(m),
        fitness, 0)) ++ population)

      val select = selection(newPopulation.sortBy { x => -fitness(x, model) },
        fitness,
        model,
        population.size)

      this(model, fitness, select, crossover,
          crossoverRate, mutationInner, mutationRate,
          localSearch, localSearchNeighbors, criterionAcceptance)
    }
  }

  private def crossOver(population: List[Permutation],
                        crossover: AbstractCrossOver[Permutation],
                        couples: List[(Int, Int)],
                        children: List[Permutation] = Nil): List[Permutation] = {
    if (couples.isEmpty)
      children
    else {
      val newChildren = crossover(population(couples.head._1), population(couples.head._2))
      crossOver(population, crossover, couples.tail, (children ++ newChildren))
    }
  }

  private def mutation(population: List[Permutation],
                       mutationInner: AbstractNeighborsGenerator[Permutation],
                       mutationRate: Float,
                       newPopulation: List[Permutation] = Nil): List[Permutation] = {
    if (population.isEmpty)
      newPopulation
    else {
      if (new java.util.Random().nextFloat() > mutationRate) {
        val indices = population.indices
        val tails = indices.tail map (i => indices drop i)
        val couples = scala.util.Random.shuffle((indices zip tails) flatMap (c => c._2 map (i => (c._1, i))))
        mutation(population.tail, mutationInner, mutationRate, newPopulation :+ mutationInner(population.head, couples.head._1, couples.head._2))
      } else
        mutation(population.tail, mutationInner, mutationRate, newPopulation :+ population.head)
    }
  }

  private def selection(population: List[Permutation],
                        fitness: AbstractFitness[Permutation, SMTWTPModel],
                        model: SMTWTPModel,
                        size: Int,
                        newPopulation: List[Permutation] = Nil): List[Permutation] = {
    if (newPopulation.size == size)
      newPopulation
    else {
      selection(population.tail, fitness, model, size, newPopulation :+ population.head)
    }
  }
}