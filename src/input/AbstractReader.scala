package input

import model.AbstractModel

trait AbstractReader[T <: AbstractModel] {
  
  def apply(path : String, nbJobs : Int, nbInstance : Int) : Array[T]
  
}