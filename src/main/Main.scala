package main

import localsearch._
import solution._
import fitness._
import neighbors._
import heuristiques._
import localsearch._
import advancedsearch._
import model._
import util.Logger
import advancedsearch.ILSSMTWTP

object Main extends App {
  
  def getDifficulties(best : Int) : Int = {
    if (best < 10000) 
      1
    else if (best < 100000)
      2
    else if (best < 500000)
      3
    else
      4
  }

  val model = input.SMTWTPReader("data/wt100")
  
  val it = (scala.io.Source.fromFile("data/wtbest100b.txt")).getLines
  
  Logger.open("out/ils_timeOut_30k_pvnd")

  for (i <- 0 until model.length) {
    val best = ((it next).replaceAll(" ", "")).toInt
    val difficulty = getDifficulties(best)
    print(best + "\t" + difficulty) 
    val time = System.currentTimeMillis()
    def timeoutAndBest() : Boolean = System.currentTimeMillis() > (30000*difficulty) + time || best >= ILSSMTWTP.currentFitnessG
    
    val initSolution = SMTWTPEDDHeuristique(model(i))
    
    val score = PermutationSMTPWTPFitness(ILSSMTWTP(initSolution,
        model(i),
        PipedVNDSMTWTPSearch,
        List(PermutationExchange, PermutationSwap, PermutationInsert),
        PermutationExchange,
        PermutationSMTPWTPFitness,
        PermutationSMTPWTPFitness(initSolution, model(i)), timeoutAndBest), model(i))
      
    val str = i+"\t"+score+"\t"+(System.currentTimeMillis()-time)+"\t"+PermutationSMTPWTPFitness.counter+"\n"
    Logger.write(str)
    print("\t"+str)
    
    ILSSMTWTP.currentFitnessG = Integer.MAX_VALUE
    ILSSMTWTP.bestFitness = Integer.MAX_VALUE
    PermutationSMTPWTPFitness.counter = 0
  }
  
  Logger.close()

}
