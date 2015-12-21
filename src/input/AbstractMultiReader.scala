package input

import model.AbstractModel

trait AbstractMultiReader[T <: AbstractModel] {
  
  def read(path : List[String], nbJobs : Int) : T
  
}