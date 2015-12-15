package main

import localsearch._
import solution._
import fitness.PermutationSMTPWTPFitness
import neighbors._
import heuristiques._

object Main extends App {
  
  val model = input.SMTWTPReader.read("data/wt100")

  val solution = SMTWTPEDDHeuristique(model(18))
  
  val time = System.currentTimeMillis()
  
  println(PermutationSMTPWTPFitness(
      BestSMTWTPSearch(
      solution,
      PermutationSMTPWTPFitness(solution,model(18)),
      model(18),
      PermutationSwap,
      PermutationSwap(solution),
      PermutationSMTPWTPFitness), model(18)))
      
  println( (System.currentTimeMillis() - time) + " ms")
  
}