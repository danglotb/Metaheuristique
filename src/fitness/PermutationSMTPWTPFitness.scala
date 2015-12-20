package fitness

import solution.Permutation
import model.SMTWTPModel

object PermutationSMTPWTPFitness extends AbstractFitness[Permutation, SMTWTPModel] {
  
  override def apply(solution : Permutation, model : SMTWTPModel) : Int = computeSMTPWTP(solution,model)
  
  private def computeSMTPWTP(solution : Permutation, model : SMTWTPModel,
      currentTime : Int = 0, i : Int = 0, score : Int = 0) : Int = {
    counter += 1
    if (i == solution.permutation.length)
      score
    else {
      val time = model.processingTimes(solution(i))+currentTime
      computeSMTPWTP(solution, model, time, i+1, score + (Math.max(time-model.dueDates(solution(i)), 0) * model.weights(solution(i))))
    }
  }
  
}