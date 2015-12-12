package fitness

import solution.Permutation
import model.SMTWTPModel

object PermutationSMTPWTPFitness extends AbstractFitness[Permutation, SMTWTPModel] {
  
  override def compute(solution : Permutation, model : SMTWTPModel) : Int = {
    var currentTime = 0
      solution.Solution.foldLeft(0) {
        case (acc,i) =>
          currentTime += model.processingTimes(i)
          acc + (Math.max(currentTime-model.dueDates(i), 0) * model.weights(i))
      }
  }
  
}