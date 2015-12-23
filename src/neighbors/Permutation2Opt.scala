package neighbors

import solution.Permutation

object Permutation2Opt extends AbstractNeighborsGenerator[Permutation] {
  
  override def apply(solution : Permutation, i : Int, j : Int) : Permutation = {
    val front = solution.permutation.take(i)
    val middle = solution.permutation.slice(i, j+1).reverse
    val back = solution.permutation.drop(j+1)
    new Permutation(front ++ middle ++ back)
  }
  
  override def apply(solution : Permutation) : List[Permutation] = {
    val indices = solution.permutation.indices
    val tails = indices.tail map (i => indices drop i)
    val couples = scala.util.Random.shuffle((indices zip tails) flatMap (c => c._2 map (i => (c._1, i))))
    couples.map { x => this(solution, x._1, x._2) }.toList
  }
  
  override def toString() : String = "2-opt"
  
}