package solution

class Permutation(Permutation : List[Int]) extends AbstractSolution {
  
  def apply(n : Int) = Permutation.apply(n)
  
  def permutation() = Permutation
  
  def size() = Permutation.size
  
  override def toString() : String = {
    Permutation.foldLeft(" ") {
      case (acc,i) => acc + i + " "
    }
  }
}