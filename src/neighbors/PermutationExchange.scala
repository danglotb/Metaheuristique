package neighbors

import solution.Permutation

object PermutationExchange extends AbstractNeighborsGenerator[Permutation] {
  
  private def exchange(solution : Permutation, i : Int) : Permutation = 
    new Permutation(solution.permutation.updated(i, solution(i+1)).updated(i+1, solution(i)))
  
  override def apply(solution : Permutation) : List[Permutation] = {
    val indices = scala.util.Random.shuffle((solution.permutation.indices).diff(Seq(solution.permutation.indices.lastElement)))
    indices.map { i => exchange(solution, i) }.toList
  }
  
}