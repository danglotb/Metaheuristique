package main

import localsearch._
import fitness.PermutationSMTPWTPFitness
import neighbors._
import heuristiques._

object Main extends App {
  
  val model = input.SMTWTPReader.read("data/wt100")

  val solution = SMTWTPEDDHeuristique(model(0))
  
  val time = System.currentTimeMillis()
  
  println(PermutationSMTPWTPFitness(
      BestSMTWTPSearch.run(
      solution,
      PermutationSMTPWTPFitness(solution,model(0)),
      model(0),
      PermutationInsert,
      PermutationInsert(solution),
      PermutationSMTPWTPFitness), model(0)))
      
  println( (System.currentTimeMillis() - time) + " ms")
  
}