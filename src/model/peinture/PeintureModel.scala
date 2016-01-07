package model.peinture

import model.AbstractModel

class PeintureModel(motif : List[List[Boolean]]) extends AbstractModel {
  
  def apply(i : Int) = motif(i)
  
  def apply(i : Int, j : Int) = motif(i)(j)
  
  def iterator() : Iterator[List[Boolean]] = motif.iterator
  
}