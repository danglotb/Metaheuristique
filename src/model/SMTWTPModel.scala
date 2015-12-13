package model

class SMTWTPModel(nbJobs : Int) extends AbstractModel {
  
  val processingTimes = Array.ofDim[Int](nbJobs)
  
  val weights = Array.ofDim[Int](nbJobs)
  
  val dueDates = Array.ofDim[Int](nbJobs)
  
  def nbJobs() : Int = nbJobs
  
}