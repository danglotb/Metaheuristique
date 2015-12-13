package heuristiques

import model.SMTWTPModel
import solution.Permutation

object SMTWTPRandomHeuristique extends AbstractHeuristique[SMTWTPModel,Permutation]{
  
  implicit override  def apply(model : SMTWTPModel) : Permutation = new Permutation(scala.util.Random.shuffle(List.range(0,model.nbJobs())))
  
}