package localsearch

import solution.AbstractSolution
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractFitness
import model.AbstractModel

trait AbstractLocalSearch[S <: AbstractSolution, M <: AbstractModel] {
  
  val score = scala.collection.mutable.ListBuffer[Int]()
  
  def apply(solution : S,
      currentFitness : Int,
      model : M, 
      neighbors : List[AbstractNeighborsGenerator[S]],
      listNeighbors : List[S],
      fitness : AbstractFitness[S,M],
      indexNeighbors : Int) : S
  
}