package main

import localsearch._
import solution._
import fitness._
import neighbors._
import heuristiques._
import localsearch._
import advancedsearch._

object Main extends App {
  
  def TimeOut() : Boolean = {
    if ((System.currentTimeMillis() - time) > 20000)
      true
    else
      false
  }

  val model = input.SMTWTPReader.read("data/wt100")

  val solution = SMTWTPEDDHeuristique(model(2))

  val time = System.currentTimeMillis()
  
  println(PermutationSMTPWTPFitness(
    ILSSMTWTP(
      solution,
      model(2),
      BestSMTWTPSearch,
      List(PermutationSwap),
      PermutationInsert,
      PermutationSMTPWTPFitness,
      PermutationSMTPWTPFitness(solution, model(2)),
      TimeOut), model(2)))

  println((System.currentTimeMillis() - time) + " ms")

}