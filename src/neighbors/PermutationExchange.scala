package neighbors

import solution.Permutation

object PermutationExchange extends AbstractNeighborsGenerator[Permutation] {
  
  implicit private def apply(solution : Permutation, i : Int) : Permutation = 
  new Permutation(solution.permutation.updated(i, solution(i+1)).updated(i+1, solution(i)))
  
  implicit override def apply(solution : Permutation) : List[Permutation] = {
    val indices = scala.util.Random.shuffle((solution.permutation.indices).diff(Seq(solution.permutation.indices.last)))
    indices.map { i => this(solution, i) }.toList
  }
  
}