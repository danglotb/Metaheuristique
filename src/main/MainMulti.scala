package main

import heuristiques.MTSPRandomHeuristique
import fitness.PermutationMTSPFitness

object MainMulti extends App {
  
  val path = List("data/randomA100.tsp","data/randomB100.tsp")
  
  val model = input.MTSPReader(path)
  
  val solution = MTSPRandomHeuristique(model)
  
  val score = PermutationMTSPFitness(solution,model)
  
  println(score)
  
}