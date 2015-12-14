package neighbors

import solution.Permutation

object PermutationExchange extends AbstractNeighborsGenerator[Permutation] {
  
  implicit override def apply(solution : Permutation, i : Int, j : Int) : Permutation = PermutationSwap(solution, i , j)
  
  implicit override def apply(solution : Permutation) : List[Permutation] = {
    val indices = scala.util.Random.shuffle((solution.permutation.indices).diff(Seq(solution.permutation.indices.lastElement)))
    indices.map { i => this(solution, i, i+1) }.toList
  }
  
}