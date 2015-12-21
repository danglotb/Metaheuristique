package heuristiques

import model.MTSPModel
import solution.Permutation

object MTSPRandomHeuristique extends AbstractHeuristique[MTSPModel,Permutation]{
  
  override  def apply(model : MTSPModel) : Permutation = new Permutation(scala.util.Random.shuffle(List.range(0,model.nbJobs)))
  
  override def toString() : String = "rnd"
  
}