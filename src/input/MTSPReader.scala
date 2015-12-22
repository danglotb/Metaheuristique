package input

import solution.Permutation
import model.MTSPModel

object MTSPReader extends AbstractMultiReader[MTSPModel] {

  def apply(path: List[String], nbJobs: Int = 100): MTSPModel = {
    val sources = getSources(path)
    val model = new MTSPModel(path.length, nbJobs)
    sources.foreach {source =>
      readMatrix(source,model(sources.indexOf(source)), 0,1)
    }
    model
  }
  
  private def readMatrix(it : Iterator[String], matrix : Array[Array[Int]], x : Int, y : Int) : Array[Array[Int]] = {
    if (!(it hasNext))
      matrix
    else {
      val value = (it next).toInt
      if (y == 100) {
        matrix(x+1)(x+1) = value
        readMatrix(it, matrix, x+1, x+2)
      } else {
        matrix(x)(y) = value
        readMatrix(it, matrix, x, y+1)
      }
    }
  }

  private def getSources(path: List[String]): List[Iterator[String]] = {
    val listSources = scala.collection.mutable.ListBuffer[Iterator[String]]()
    path.foreach { p =>
      listSources += removeHeader((scala.io.Source.fromFile(p).getLines()))
    }
    listSources.toList
  }

  def removeHeader(it : Iterator[String], currentLine: String = ""): Iterator[String] = {
    try {
      if (currentLine.toInt == 0)
        return it
      else
        removeHeader(it, it next)
    } catch {
      case  e : java.lang.NumberFormatException =>  removeHeader(it, it next)
    }
  }

}