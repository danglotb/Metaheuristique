package neighbors

import solution.Permutation

object PermutationInsert extends AbstractNeighborsGenerator[Permutation] {
  
  implicit override def apply(solution : Permutation, i : Int, j : Int) : Permutation = {
    
    val min = Math.min(i,j)
    val max = Math.max(i,j)
    
    val front = solution.permutation.drop(min)
    val end  = solution.permutation.dropRight(max-1)
    val middle = solution.permutation.diff(front).diff(end).diff(List(solution(i)))
    
    if (i > j)
      new Permutation( (front :+ solution(i)) ++ middle ++ end )
    else
      new Permutation( front ++ (middle :+ solution(i)) ++ end)
  }
  
  override def apply(solution : Permutation) : List[Permutation] = {
    val indices = solution.permutation.indices
    val tails = indices.tail map (i => indices drop i)
    val couples = scala.util.Random.shuffle((indices zip tails) flatMap (c => c._2 map (i => (c._1, i))))
    couples.map { x => this(solution, x._1, x._2) }.toList
  }
  
}