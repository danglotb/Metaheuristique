package neighbors

import solution.Permutation

object PermutationExchange extends AbstractNeighborsGenerator[Permutation] {
  
  override def apply(solution : Permutation, i : Int, j : Int) : Permutation = PermutationSwap(solution,i,j)
  
  override def apply(solution : Permutation) : List[Permutation] = {
    val indices = scala.util.Random.shuffle((solution.permutation.indices).diff(Seq(solution.permutation.indices.last)))
    indices.map { i => this(solution, i, i+1) }.toList
  }
  
  override def toString() : String = "exchange"
  
}