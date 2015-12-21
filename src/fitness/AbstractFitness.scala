
package fitness

import solution.AbstractSolution
import model.AbstractModel

trait AbstractFitness[S <: AbstractSolution, M <: AbstractModel] {
  
  var counter : Int = 0
  
  def apply(solution : S, model : M) : Int
  
}