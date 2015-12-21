package input

import model.AbstractModel

trait AbstractReader[T <: AbstractModel] {
  
  def read(path : String, nbJobs : Int, nbInstance : Int) : Array[T]
  
}