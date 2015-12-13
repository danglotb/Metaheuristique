package neighbors

import solution.Permutation

object PermutationInsert extends AbstractNeighborsGenerator[Permutation] {
  
  private def insert(solution : Permutation, i : Int, j : Int) : Permutation = {
    val front = solution.permutation.drop(i-1)
    val middle = solution.permutation.slice(i+1,j+1)
    val end  = solution.permutation.dropRight(j)
    new Permutation(end:::solution(i)::middle:::front)
  }
  
  override def apply(solution : Permutation) : List[Permutation] = {
    val indices = solution.permutation.indices
    val tails = indices.tail map (i => indices drop i)
    val couples = scala.util.Random.shuffle((indices zip tails) flatMap (c => c._2 map (i => (c._1, i))))
    couples.map { x => insert(solution, x._1, x._2) }.toList
  }
  
}