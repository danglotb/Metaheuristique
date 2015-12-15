package main

import localsearch._
import solution._
import fitness.PermutationSMTPWTPFitness
import neighbors._
import heuristiques._
import vndsearch._

object Main extends App {

  val model = input.SMTWTPReader.read("data/wt100")

  val solution = SMTWTPEDDHeuristique(model(2))

  val time = System.currentTimeMillis()

  println(PermutationSMTPWTPFitness(
    PipedVNDSMTWTPSearch(
      solution,
      PermutationSMTPWTPFitness(solution, model(2)),
      model(2),
      List(PermutationExchange, PermutationSwap, PermutationInsert),
      PermutationExchange(solution),
      0,
      PermutationSMTPWTPFitness), model(2)))

  println((System.currentTimeMillis() - time) + " ms")

}