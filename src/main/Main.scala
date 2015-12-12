package main

import localsearch.FirstSMTWTPSearch
import fitness.PermutationSMTPWTPFitness
import neighbors.PermutationSwap

object Main extends App {
  
  val model = input.SMTWTPReader.read("data/wt100")
  
  var firstSolution = heuristiques.SMTWTPEDDHeuristique.buildHeuristique(model(0))
  
  println(firstSolution)
  
  firstSolution.Solution.foreach { s => print(model(0).dueDates(s) +" ") } 
  
  println()
  
  val localSearchSol = FirstSMTWTPSearch.run(firstSolution, model(0), PermutationSwap, PermutationSMTPWTPFitness)
  
  println(PermutationSMTPWTPFitness.compute(localSearchSol, model(0)))
  
}