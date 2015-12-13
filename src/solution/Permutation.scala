package solution

class Permutation(Permutation : List[Int]) extends AbstractSolution {
  
  implicit def apply(n : Int) = Permutation.apply(n)
  
  def permutation() = Permutation
  
  override def toString() : String = {
    Permutation.foldLeft(" ") {
      case (acc,i) => acc + i + " "
    }
  }
}