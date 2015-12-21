package model

class MTSPModel(nbObjectif : Int,nbJob : Int) extends AbstractModel {
  
  val values = Array.ofDim[Int](nbObjectif,nbJobs,nbJob)
  
  def apply(i : Int) = values(i)
  
  def apply(i : Int, j : Int) = values(i)(j)
  
  def apply(i : Int, j : Int, k : Int) = values(i)(j)(k)
  
  def nbObjectifs = nbObjectif
  
  def nbJobs = nbJob
  
}