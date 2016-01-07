package fitness.peinture

import fitness.AbstractFitness
import solution.peinture.Instructions
import model.peinture.PeintureModel
import model.peinture.PeintureModel


object InstructionsFitness extends AbstractFitness[Instructions, PeintureModel] {
    
  def apply(solution : Instructions, model : PeintureModel) : Int = solution.length()
  
}