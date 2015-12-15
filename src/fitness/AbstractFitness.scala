
package fitness

import solution.AbstractSolution
import model.AbstractModel

trait AbstractFitness[S <: AbstractSolution, M <: AbstractModel ] {
  
  def apply(solution : S, model : M) : Int
  
}