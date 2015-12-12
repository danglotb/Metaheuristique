package input

import model.AbstractModel

trait AbstractReader[T <: AbstractModel] {
  
  def read(path : String, nbJobs : Int = 125, nbInstance : Int = 100) : Array[T]
  
}