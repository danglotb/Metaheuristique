package model

class SMTWTPModel(nbJobs : Int) extends AbstractModel {
  
  val processingTimes = Array.ofDim[Int](nbJobs)
  
  val weights = Array.ofDim[Int](nbJobs)
  
  val dueDates = Array.ofDim[Int](nbJobs)
  
  def nbJobs() : Int = nbJobs
  
  override def toString() : String = {
    val time = "T :\n" + processingTimes.foldLeft(" ") {
      case (acc,i) => acc + i + " "
    }
    val weight = "\nW : \n" +  weights.foldLeft(" ") {
      case (acc,i) => acc + i + " "
    }
    val date = "\nD : \n" +  dueDates.foldLeft(" ") {
      case (acc,i) => acc + i + " "
    }
    return time + weight + date
  }
  
}