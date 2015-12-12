package heuristiques

import model.SMTWTPModel
import solution.Permutation

object SMTWTPRandomHeuristique extends AbstractHeuristique[SMTWTPModel,Permutation]{
  
  def buildHeuristique(model : SMTWTPModel) : Permutation = new Permutation((scala.util.Random.shuffle(Range(0,model.nbJobs,1).toTraversable)).toArray)
  
}