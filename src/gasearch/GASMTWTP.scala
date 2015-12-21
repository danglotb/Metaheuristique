package gasearch

import solution.Permutation
import model.SMTWTPModel
import crossover.AbstractCrossOver
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness

object GASMTWTP extends AbstractGASearch[Permutation, SMTWTPModel] {

  override def apply(model: SMTWTPModel,
                     population: List[Permutation],
                     crossover: AbstractCrossOver[Permutation],
                     mutationInner: AbstractNeighborsGenerator[Permutation],
                     probaMutation: Float,
                     numberGene: Int,
                     fitness: AbstractFitness[Permutation, SMTWTPModel],
                     currentGene: Int): List[Permutation] = {
    if (currentGene == numberGene)
      population
    else {
      val indices = population.indices
      val tails = indices.tail map (i => indices drop i)
      val couples = scala.util.Random.shuffle((indices zip tails) flatMap (c => c._2 map (i => (c._1, i))))

      val children = crossOver(population, crossover, couples.toList)

      val indicesJobs = Range(0, model.nbJobs())
      val tailsJobs = indicesJobs.tail map (i => indicesJobs drop i)
      val couplesJobs = scala.util.Random.shuffle((indicesJobs zip tailsJobs) flatMap (c => c._2 map (i => (c._1, i))))

      val mutants = mutation(population, mutationInner, (population.size * probaMutation).toInt,
        scala.util.Random.shuffle(indices.toList), couplesJobs.toList)

      val select = selection((population ++ children ++ mutants), fitness, model, population.size)

      this(model, select, crossover, mutationInner, probaMutation, numberGene, fitness, currentGene + 1)
    }
  }

  private def crossOver(population: List[Permutation],
                        crossover: AbstractCrossOver[Permutation],
                        couples: List[(Int, Int)],
                        children: List[Permutation] = Nil): List[Permutation] = {
    if (children.length == population.length / 2)
      children
    else {
      val newChildren = crossover(population(couples.head._1), population(couples.head._2))
      crossOver(population, crossover, couples.tail, (children ++ newChildren))
    }
  }

  private def mutation(population: List[Permutation],
                       mutationInner: AbstractNeighborsGenerator[Permutation],
                       sizeMutation: Int,
                       indices: List[Int],
                       couples: List[(Int, Int)],
                       mutants: List[Permutation] = Nil): List[Permutation] = {
    if (mutants.size == sizeMutation)
      mutants
    else {
      val mutant = mutationInner(population(indices.head), couples.head._1, couples.head._2)
      mutation(population, mutationInner, sizeMutation, indices.tail, couples.tail, mutants :+ mutant)
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
      val best = (population).maxBy { x => fitness(x, model) }
      selection(population.filter(x => x != best), fitness, model, size, newPopulation :+ best)
    }
  }

}