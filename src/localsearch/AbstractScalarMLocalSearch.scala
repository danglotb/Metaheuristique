package localsearch

import solution.AbstractSolution
import neighbors.AbstractNeighborsGenerator
import fitness.AbstractMFitness
import model.AbstractModel

trait AbstractScalarMLocalSearch[S <: AbstractSolution, M <: AbstractModel] {
  
  val score = scala.collection.mutable.ListBuffer[Int]()
  
  def apply(solution : S,
      currentFitness : Int,
      model : M, 
      neighbors : List[AbstractNeighborsGenerator[S]],
      listNeighbors : List[S],
      fitness : AbstractMFitness[S,M],
      indexNeighbors : Int,
      paretoFront : List[S],
      currentRate : List[Double]) : List[S]
  
}