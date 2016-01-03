package fitness

import solution.Permutation
import model.MTSPModel

object PermutationScalarMTSPFitness extends AbstractScalarMFitness[Permutation, MTSPModel] {

  override def apply(fitness: AbstractMFitness[Permutation, MTSPModel],
                     rate: List[Double],
                     solution: Permutation,
                     model: MTSPModel): Int = {
    val fitnesses = fitness(solution, model)

    rate.foldLeft(0.0) {
      case (acc, r) =>
        acc + (r * fitnesses(rate.indexOf(r)))
    }.toInt
  }
  
  def buildWeight2D(beg : Double, end : Double, step : Double) : List[List[Double]] = {
    val list = scala.collection.mutable.ListBuffer[List[Double]]()
    for (i <- beg until end by step) {
      list += (List(i,end))
    }
    list.toList
  }
  

  def buildWeigth2D(current: Double, end: Double, step: Double, list: List[List[Double]] = Nil): List[List[Double]] = {
    if (list.length == (end / step) + 1)
      list
    else
      buildWeigth2D(current + step, end, step, list :+ List(current, end - current))
  }
  
}