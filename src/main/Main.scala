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

object Main extends App {

  val model = input.SMTWTPReader("data/wt100")

  var init : AbstractHeuristique[SMTWTPModel, Permutation] = SMTWTPRandomHeuristique

  var neighborsGen : List[AbstractNeighborsGenerator[Permutation]] = List(PermutationExchange, PermutationSwap, PermutationInsert)

  var select : AbstractLocalSearch[Permutation,SMTWTPModel] = VNDSMTWTPSearch

  var str = select.toString + "_" + init.toString + "_" + neighborsGen(1).toString() + "_" + neighborsGen(2).toString() 
  
  println(str)

  Logger.open("out/" + str)

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

    Logger.write(m + "\t" + score + "\t" + (System.currentTimeMillis()-time)  +"\t" + PermutationSMTPWTPFitness.counter + "\n")

    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()
  
  /**
   * 
   */
  
  init = SMTWTPRandomHeuristique

  neighborsGen = List(PermutationExchange, PermutationInsert, PermutationSwap)

  select = VNDSMTWTPSearch

  str = select.toString + "_" + init.toString + "_" + neighborsGen(1).toString() + "_" + neighborsGen(2).toString() 
  
  println(str)

  Logger.open("out/" + str)

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

    Logger.write(m + "\t" + score + "\t" + (System.currentTimeMillis()-time)  +"\t" + PermutationSMTPWTPFitness.counter + "\n")

    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()
  
  /**
   * 
   */
  
  init = SMTWTPEDDHeuristique

  neighborsGen = List(PermutationExchange, PermutationInsert, PermutationSwap)

  select = VNDSMTWTPSearch

  str = select.toString + "_" + init.toString + "_" + neighborsGen(1).toString() + "_" + neighborsGen(2).toString() 
  
  println(str)

  Logger.open("out/" + str)

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

    Logger.write(m + "\t" + score + "\t" + (System.currentTimeMillis()-time)  +"\t" + PermutationSMTPWTPFitness.counter + "\n")

    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()
  
  /**
   * 
   */
  
  init = SMTWTPEDDHeuristique

  neighborsGen = List(PermutationExchange, PermutationSwap, PermutationInsert)

  select = VNDSMTWTPSearch

  str = select.toString + "_" + init.toString + "_" + neighborsGen(1).toString() + "_" + neighborsGen(2).toString() 
  
  println(str)

  Logger.open("out/" + str)

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

    Logger.write(m + "\t" + score + "\t" + (System.currentTimeMillis()-time)  +"\t" + PermutationSMTPWTPFitness.counter + "\n")

    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()
 
  
  /**
   * 
   * 
   * 
   * 
   */
  
  init = SMTWTPRandomHeuristique

  neighborsGen = List(PermutationExchange, PermutationSwap, PermutationInsert)

  select = PipedVNDSMTWTPSearch

  str = select.toString + "_" + init.toString + "_" + neighborsGen(1).toString() + "_" + neighborsGen(2).toString() 
  
  println(str)

  Logger.open("out/" + str)

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

    Logger.write(m + "\t" + score + "\t" + (System.currentTimeMillis()-time)  +"\t" + PermutationSMTPWTPFitness.counter + "\n")

    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()
  
  /**
   * 
   */
  
  init = SMTWTPRandomHeuristique

  neighborsGen = List(PermutationExchange, PermutationInsert, PermutationSwap)

  select = PipedVNDSMTWTPSearch

  str = select.toString + "_" + init.toString + "_" + neighborsGen(1).toString() + "_" + neighborsGen(2).toString() 
  
  println(str)

  Logger.open("out/" + str)

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

    Logger.write(m + "\t" + score + "\t" + (System.currentTimeMillis()-time)  +"\t" + PermutationSMTPWTPFitness.counter + "\n")

    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()
  
  /**
   * 
   */
  
  init = SMTWTPEDDHeuristique

  neighborsGen = List(PermutationExchange, PermutationInsert, PermutationSwap)

  select = PipedVNDSMTWTPSearch

  str = select.toString + "_" + init.toString + "_" + neighborsGen(1).toString() + "_" + neighborsGen(2).toString() 
  
  println(str)

  Logger.open("out/" + str)

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

    Logger.write(m + "\t" + score + "\t" + (System.currentTimeMillis()-time)  +"\t" + PermutationSMTPWTPFitness.counter + "\n")

    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()
  
  /**
   * 
   */
  
  init = SMTWTPEDDHeuristique

  neighborsGen = List(PermutationExchange, PermutationSwap, PermutationInsert)

  select = PipedVNDSMTWTPSearch

  str = select.toString + "_" + init.toString + "_" + neighborsGen(1).toString() + "_" + neighborsGen(2).toString() 
  
  println(str)

  Logger.open("out/" + str)

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

    Logger.write(m + "\t" + score + "\t" + (System.currentTimeMillis()-time)  +"\t" + PermutationSMTPWTPFitness.counter + "\n")

    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()

}