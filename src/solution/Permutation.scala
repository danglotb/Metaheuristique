package solution

class Permutation(size : Int) extends AbstractSolution {
    
  private var solution = Range(0,size,1).toArray
  
  def this(a : Array[Int])  {
    this(a.length)
    solution = a
  }
  
  def Solution = solution
  
  override def toString() : String = {
    var str = ""
    solution.foreach { s =>
      str += s + " "
    }
    str
  }
  
}