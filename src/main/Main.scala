package main

import localsearch._
import solution._
import fitness._
import neighbors._
import heuristiques._
import localsearch._
import advancedsearch._
import util.Logger

object Main extends App {
  
  val model = input.SMTWTPReader.read("data/wt100")
  
  val init = SMTWTPRandomHeuristique
  
  val neighborsGen = List(PermutationExchange)
  
  val select = BestSMTWTPSearch
  
  val str  = select.toString+"_"+init.toString+"_"+neighborsGen(0).toString()
  
  Logger.open("out/"+str)

  for (m <- 0 until model.length) {
    println(m)
    val time = System.currentTimeMillis()
    val solution = init(model(m))
    val score = PermutationSMTPWTPFitness(
      select(
        solution,
        PermutationSMTPWTPFitness(solution, model(m)),
        model(m),
        neighborsGen,
        (neighborsGen(0))(solution),
        PermutationSMTPWTPFitness,
        0), model(m))
        
    Logger.write(m+"\t"+score+"\t"+PermutationSMTPWTPFitness.counter+"\n")
    
    PermutationSMTPWTPFitness.counter = 0
  }
  
  Logger.close()

}