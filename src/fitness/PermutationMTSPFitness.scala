package fitness

import solution.Permutation
import model.MTSPModel

object PermutationMTSPFitness extends AbstractFitness[Permutation,MTSPModel] {
  
   def apply(solution : Permutation, model : MTSPModel) : Int = 0
  
}