package heuristiques

import model.SMTWTPModel
import solution.Permutation

object SMTWTPEDDHeuristique extends AbstractHeuristique[SMTWTPModel,Permutation]{
  
  override def apply(model : SMTWTPModel) : Permutation = new Permutation(List.range(0,model.nbJobs()).sortBy { x => model.dueDates(x) })
  
}