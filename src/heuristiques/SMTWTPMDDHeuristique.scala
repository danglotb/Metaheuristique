package heuristiques

import model.SMTWTPModel
import solution.Permutation

object SMTWTPMDDHeuristique extends AbstractHeuristique[SMTWTPModel,Permutation]{
  
  implicit override def apply(model : SMTWTPModel) : Permutation = build(model)
  
  private def build(model : SMTWTPModel, list : List[Int] = Nil, acc : Int = 0) : Permutation = {
    if (list.length == model.nbJobs)
      new Permutation(list)
    else {
      val index = (List.range(0,model.nbJobs()).diff(list)).maxBy { x => Math.max(acc+model.processingTimes(x), model.dueDates(x))}
      build(model, list :+ index , acc + model.processingTimes(index))
    } 
  }
  
}