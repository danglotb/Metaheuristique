package input.peinture

import model.peinture.PeintureModel

object PeintureReader {

  def apply(path: String): PeintureModel = readFile(scala.io.Source.fromFile(path).getLines())

  private def readFile(it: Iterator[String], model: List[List[Boolean]] = Nil): PeintureModel = {
    if (!it.hasNext)
      new PeintureModel(model)
    else
      readFile(it, model :+ readLine((it.next).toArray))
  }
  
  private def readLine(s : Array[Char], index : Int = 0,value : List[Boolean] = Nil) : List[Boolean] = {
    if (index == s.length)
      value
    else
      readLine(s, index+1, value :+ (s(index) == '#')) 
  }

}