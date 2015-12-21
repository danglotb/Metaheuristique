
package fitness

import solution.AbstractSolution
import model.AbstractModel

trait AbstractMFitness[S <: AbstractSolution, M <: AbstractModel] {
  
  var counter : Int = 0
  
  def apply(solution : S, model : M) : List[Int]
  
}