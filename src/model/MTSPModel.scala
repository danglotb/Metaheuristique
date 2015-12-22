package model

class MTSPModel(nbObjectif : Int,nbJob : Int) extends AbstractModel {
  
  val values = Array.ofDim[Int](nbObjectif,nbJobs,nbJob)
  
  def apply(i : Int) = values(i)
  
  def apply(i : Int, j : Int) = values(i)(j)
  
  def apply(i : Int, j : Int, k : Int) = values(i)(j)(k)
  
  def nbObjectifs = nbObjectif
  
  def nbJobs = nbJob
  
  override def toString : String = {
    values.foldLeft(""){
      case (acc,i) => acc + i.foldLeft("") {
        case (acc,j) => acc + j.foldLeft("") {
          case (acc,k) => acc + k + "\t"
        } + "\n"
      } + "\n"
    }
  }
  
}