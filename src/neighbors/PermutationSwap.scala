package neighbors

import solution.Permutation

object PermutationSwap extends AbstractNeighborsGenerator[Permutation] {

  implicit private def apply(solution: Permutation, i: Int, j: Int) : Permutation =
      new Permutation(solution.permutation.updated(i, solution(j)).updated(j, solution(i)))
  
  implicit override def apply(solution: Permutation): List[Permutation] = {
    val indices = solution.permutation.indices
    val tails = indices.tail map (i => indices drop i)
    val couples = scala.util.Random.shuffle((indices zip tails) flatMap (c => c._2 map (i => (c._1, i))))
    couples.map { x => this(solution, x._1, x._2) }.toList
  }
}