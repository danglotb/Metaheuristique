package heuristiques

import model.SMTWTPModel
import solution.Permutation

object SMTWTPEDDHeuristique extends AbstractHeuristique[SMTWTPModel,Permutation]{
  
  def buildHeuristique(model : SMTWTPModel) : Permutation =  {
    new Permutation(Range(0,model.nbJobs,1).sortBy { x => -model.dueDates(x) }.toArray)
  }
  
}