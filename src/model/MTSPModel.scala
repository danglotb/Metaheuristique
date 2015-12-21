package model

class MTSPModel(nbObjectif : Int,nbJobs : Int) extends AbstractModel {
  
  val values = Array.ofDim[Int](nbObjectif,nbJobs,nbJobs)
  
  def apply(i : Int) = values(i)
  
}