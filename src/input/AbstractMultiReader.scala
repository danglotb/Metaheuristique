package input

import model.AbstractModel

trait AbstractMultiReader[T <: AbstractModel] {
  
  def apply(path : List[String], nbJobs : Int) : T
  
}