package input

import model.SMTWTPModel

object SMTWTPReader extends AbstractReader[SMTWTPModel] {

  override def apply(path: String, nbJobs : Int = 100, nbInstance : Int = 125) : Array[SMTWTPModel] = {
    
    val source = scala.io.Source.fromFile(path)
    
    val iterator = source getLines
    
    val model = Array.ofDim[SMTWTPModel](nbInstance)
    
    for (m <- 0 until nbInstance)
       model(m) = new SMTWTPModel(nbJobs)
    
    var m = 0
    var i = 0
    var j = 0
    
    while (iterator hasNext) {
      val sc = new java.util.Scanner( (iterator next)replaceAll(" +", "\t"))
      while (sc hasNext) {
        getArray(model(m),i)(j) = (sc next).toInt
        j += 1
        if (j == nbJobs) {
          j = 0
          i += 1
          if (i == 3) {
            i = 0
            m += 1
          }
        }
      }
    }
    model
  }
  
  private def getArray(model : SMTWTPModel, i : Int) : Array[Int] = {
    i match {
      case 0 => model.processingTimes
      case 1 => model.weights
      case 2 => model.dueDates
      case _ => throw new IllegalArgumentException
    }
  }
}



