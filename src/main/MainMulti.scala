package main

import heuristiques.MTSPRandomHeuristique
import model.MTSPModel
import fitness.PermutationMTSPFitness
import solution.Permutation
import filter.PermutationMTSPFilter

object MainMulti extends App {
  
  def buildRandomInstance(model : MTSPModel, nbInstance : Int = 500, list : List[Permutation] = Nil) : List[Permutation] = {
    if (list.size == nbInstance)
      list
    else
      buildRandomInstance(model,nbInstance, list :+ MTSPRandomHeuristique(model))
  }
  
  def buildRandomInstanceFilterOnLine(model : MTSPModel, 
      nbInstance : Int = 500,
      list : List[Permutation] = Nil) : List[Permutation] = {
    if (list.size == nbInstance)
      list
    else {
      buildRandomInstance(model,nbInstance, PermutationMTSPFilter( (list :+ MTSPRandomHeuristique(model)), model))
    }
  }
  
  val path = List("data/randomA100.tsp","data/randomB100.tsp")
  
  val model = input.MTSPReader(path)
  
  val random = buildRandomInstance(model)
  
  val randomOffLineFilter = PermutationMTSPFilter(random, model)
  
  println(randomOffLineFilter)
  
  val randomOnline = buildRandomInstanceFilterOnLine(model)
  
}