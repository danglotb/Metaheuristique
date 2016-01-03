package main

import solution.Permutation
import heuristiques._
import model.SMTWTPModel
import neighbors._
import gasearch._
import crossover._
import fitness._
import util.Logger
import localsearch._

object MainMeme extends App {

  def getDifficulties(best: Int): Int = {
    if (best < 10000)
      1
    else if (best < 100000)
      2
    else if (best < 500000)
      3
    else
      4
  }

  def initPopulation(size: Int, model: SMTWTPModel, population: List[Permutation] = Nil): List[Permutation] = {
    if (size == population.length)
      population
    else
      initPopulation(size, model, population :+ SMTWTPRandomHeuristique(model))
  }

  /**
   * 100	0.4	100
   */

  val model = input.SMTWTPReader("data/wt100")

  def generation(): Boolean = nbGeneration < MASMTWTP.nbGeneration

  var sizePopulation = 5
  var mutation: Float = 0.4f
  var nbGeneration = 5
  var crossoverRate = 0.4f

  Logger.open("out/MA_" + sizePopulation + "_" + mutation + "_" + nbGeneration + "_" + crossoverRate)
  var it = (scala.io.Source.fromFile("data/wtbest100b.txt")).getLines

  for (i <- 0 until model.length) {
    val best = ((it next).replaceAll(" ", "")).toInt
    val difficulty = getDifficulties(best)
    if (difficulty == 1) {
      val init = initPopulation(sizePopulation - 2, model(i)) :+ SMTWTPMDDHeuristique(model(i)) :+ SMTWTPEDDHeuristique(model(i))
      val time = System.currentTimeMillis()
      def timeoutAndBest(): Boolean = System.currentTimeMillis() > (30000 * difficulty) + time

      println(i)

      val population = MASMTWTP(model(i),
        PermutationSMTPWTPFitness,
        init,
        COPositionBaseSMTWTP,
        crossoverRate,
        PermutationSwap,
        mutation,
        FirstSMTWTPSearch,
        List(PermutationSwap),
        generation)
      val timeElapsed = (System.currentTimeMillis() - time)

      val scores = population.map { p => PermutationSMTPWTPFitness(p, model(i)) }

      val str = i + "\t" + scores.min + "\t" + timeElapsed + "\t" + PermutationSMTPWTPFitness.counter + "\n"
      Logger.write(str)
      print("\t" + str)
      MASMTWTP.nbGeneration = 0
      PermutationSMTPWTPFitness.counter = 0
    }
  }

  Logger.close()

  /**
   * 100	0.4	200
   */

  sizePopulation = 10
  mutation = 0.4f
  nbGeneration = 5
  crossoverRate = 0.4f

  Logger.open("out/MA_" + sizePopulation + "_" + mutation + "_" + nbGeneration + "_" + crossoverRate)
  it = (scala.io.Source.fromFile("data/wtbest100b.txt")).getLines

  for (i <- 0 until model.length) {
    val best = ((it next).replaceAll(" ", "")).toInt
    val difficulty = getDifficulties(best)
    val init = initPopulation(sizePopulation - 2, model(i)) :+ SMTWTPMDDHeuristique(model(i)) :+ SMTWTPEDDHeuristique(model(i))
    val time = System.currentTimeMillis()
    def timeoutAndBest(): Boolean = System.currentTimeMillis() > (30000 * difficulty) + time

    print(i + "\t" + best)

    val population = MASMTWTP(model(i),
      PermutationSMTPWTPFitness,
      init,
      COPositionBaseSMTWTP,
      crossoverRate,
      PermutationSwap,
      mutation,
      PipedVNDSMTWTPSearch,
      List(PermutationExchange, PermutationSwap, PermutationInsert),
      generation)
    val timeElapsed = (System.currentTimeMillis() - time)

    val scores = population.map { p => PermutationSMTPWTPFitness(p, model(i)) }

    val str = i + "\t" + scores.min + "\t" + timeElapsed + "\t" + PermutationSMTPWTPFitness.counter + "\n"
    Logger.write(str)
    print("\t" + str)
    MASMTWTP.nbGeneration = 0
    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()

  /**
   * 200	0.4	100
   */

  sizePopulation = 10
  mutation = 0.4f
  nbGeneration = 5
  crossoverRate = 0.4f

  Logger.open("out/MA_" + sizePopulation + "_" + mutation + "_" + nbGeneration + "_" + crossoverRate)
  it = (scala.io.Source.fromFile("data/wtbest100b.txt")).getLines

  for (i <- 0 until model.length) {
    val best = ((it next).replaceAll(" ", "")).toInt
    val difficulty = getDifficulties(best)
    val init = initPopulation(sizePopulation - 2, model(i)) :+ SMTWTPMDDHeuristique(model(i)) :+ SMTWTPEDDHeuristique(model(i))
    val time = System.currentTimeMillis()
    def timeoutAndBest(): Boolean = System.currentTimeMillis() > (30000 * difficulty) + time

    print(i + "\t" + best)

    val population = MASMTWTP(model(i),
      PermutationSMTPWTPFitness,
      init,
      COPositionBaseSMTWTP,
      crossoverRate,
      PermutationSwap,
      mutation,
      PipedVNDSMTWTPSearch,
      List(PermutationExchange, PermutationSwap, PermutationInsert),
      generation)
    val timeElapsed = (System.currentTimeMillis() - time)

    val scores = population.map { p => PermutationSMTPWTPFitness(p, model(i)) }

    val str = i + "\t" + scores.min + "\t" + timeElapsed + "\t" + PermutationSMTPWTPFitness.counter + "\n"
    Logger.write(str)
    print("\t" + str)
    MASMTWTP.nbGeneration = 0
    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()

  /**
   * 200	0.4	200
   */

  sizePopulation = 10
  mutation = 0.4f
  nbGeneration = 10
  crossoverRate = 0.4f

  Logger.open("out/MA_" + sizePopulation + "_" + mutation + "_" + nbGeneration + "_" + crossoverRate)
  it = (scala.io.Source.fromFile("data/wtbest100b.txt")).getLines

  for (i <- 0 until model.length) {
    val best = ((it next).replaceAll(" ", "")).toInt
    val difficulty = getDifficulties(best)
    val init = initPopulation(sizePopulation - 2, model(i)) :+ SMTWTPMDDHeuristique(model(i)) :+ SMTWTPEDDHeuristique(model(i))
    val time = System.currentTimeMillis()
    def timeoutAndBest(): Boolean = System.currentTimeMillis() > (30000 * difficulty) + time

    print(i + "\t" + best)

    val population = MASMTWTP(model(i),
      PermutationSMTPWTPFitness,
      init,
      COPositionBaseSMTWTP,
      crossoverRate,
      PermutationSwap,
      mutation,
      PipedVNDSMTWTPSearch,
      List(PermutationExchange, PermutationSwap, PermutationInsert),
      generation)
    val timeElapsed = (System.currentTimeMillis() - time)

    val scores = population.map { p => PermutationSMTPWTPFitness(p, model(i)) }

    val str = i + "\t" + scores.min + "\t" + timeElapsed + "\t" + PermutationSMTPWTPFitness.counter + "\n"
    Logger.write(str)
    print("\t" + str)
    MASMTWTP.nbGeneration = 0
    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()
}

object MainGene extends App {

  def getDifficulties(best: Int): Int = {
    if (best < 10000)
      1
    else if (best < 100000)
      2
    else if (best < 500000)
      3
    else
      4
  }

  def initPopulation(size: Int, model: SMTWTPModel, population: List[Permutation] = Nil): List[Permutation] = {
    if (size == population.length)
      population
    else
      initPopulation(size, model, population :+ SMTWTPRandomHeuristique(model))
  }

  /**
   * 100	0.4	100
   */

  val model = input.SMTWTPReader("data/wt100")
  var sizePopulation = 100
  var mutation: Float = 0.4f
  var nbGeneration = 100

  Logger.open("out/GA_" + sizePopulation + "_" + mutation + "_" + nbGeneration)
  var it = (scala.io.Source.fromFile("data/wtbest100b.txt")).getLines

  for (i <- 0 until model.length) {
    val best = ((it next).replaceAll(" ", "")).toInt
    if (getDifficulties(best) == 1) {
      val init = initPopulation(sizePopulation - 2, model(i)) :+ SMTWTPMDDHeuristique(model(i)) :+ SMTWTPEDDHeuristique(model(i))
      val time = System.currentTimeMillis()

      print(i + "\t" + best)

      val population = GASMTWTP(model(i),
        init,
        COPositionBaseSMTWTP,
        PermutationSwap,
        mutation,
        nbGeneration,
        PermutationSMTPWTPFitness)
      val timeElapsed = (System.currentTimeMillis() - time)

      val scores = population.map { p => PermutationSMTPWTPFitness(p, model(i)) }

      val str = scores.min + "\t" + timeElapsed + "\t" + PermutationSMTPWTPFitness.counter + "\n"
      Logger.write(str)
      print("\t" + str)
      PermutationSMTPWTPFitness.counter = 0
    }
  }

  Logger.close()

  /**
   * 100	0.4	200
   */

  sizePopulation = 100
  mutation = 0.4f
  nbGeneration = 200

  Logger.open("out/GA_" + sizePopulation + "_" + mutation + "_" + nbGeneration)
  it = (scala.io.Source.fromFile("data/wtbest100b.txt")).getLines

  for (i <- 0 until model.length) {
    val best = ((it next).replaceAll(" ", "")).toInt
    val init = initPopulation(sizePopulation - 2, model(i)) :+ SMTWTPMDDHeuristique(model(i)) :+ SMTWTPEDDHeuristique(model(i))
    val time = System.currentTimeMillis()

    print(i + "\t" + best)

    val population = GASMTWTP(model(i),
      init,
      COPositionBaseSMTWTP,
      PermutationSwap,
      mutation,
      nbGeneration,
      PermutationSMTPWTPFitness)
    val timeElapsed = (System.currentTimeMillis() - time)

    val scores = population.map { p => PermutationSMTPWTPFitness(p, model(i)) }

    val str = scores.min + "\t" + timeElapsed + "\t" + PermutationSMTPWTPFitness.counter + "\n"
    Logger.write(str)
    print("\t" + str)
    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()

  /**
   * 200	0.4	100
   */

  sizePopulation = 200
  mutation = 0.4f
  nbGeneration = 100

  Logger.open("out/GA_" + sizePopulation + "_" + mutation + "_" + nbGeneration)
  it = (scala.io.Source.fromFile("data/wtbest100b.txt")).getLines

  for (i <- 0 until model.length) {
    val best = ((it next).replaceAll(" ", "")).toInt
    val init = initPopulation(sizePopulation - 2, model(i)) :+ SMTWTPMDDHeuristique(model(i)) :+ SMTWTPEDDHeuristique(model(i))
    val time = System.currentTimeMillis()

    print(i + "\t" + best)

    val population = GASMTWTP(model(i),
      init,
      COPositionBaseSMTWTP,
      PermutationSwap,
      mutation,
      nbGeneration,
      PermutationSMTPWTPFitness)
    val timeElapsed = (System.currentTimeMillis() - time)

    val scores = population.map { p => PermutationSMTPWTPFitness(p, model(i)) }

    val str = scores.min + "\t" + timeElapsed + "\t" + PermutationSMTPWTPFitness.counter + "\n"
    Logger.write(str)
    print("\t" + str)
    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()

  /**
   * 200	0.4	100
   */

  sizePopulation = 200
  mutation = 0.4f
  nbGeneration = 200

  Logger.open("out/GA_" + sizePopulation + "_" + mutation + "_" + nbGeneration)
  it = (scala.io.Source.fromFile("data/wtbest100b.txt")).getLines

  for (i <- 0 until model.length) {
    val best = ((it next).replaceAll(" ", "")).toInt
    val init = initPopulation(sizePopulation - 2, model(i)) :+ SMTWTPMDDHeuristique(model(i)) :+ SMTWTPEDDHeuristique(model(i))
    val time = System.currentTimeMillis()

    print(i + "\t" + best)

    val population = GASMTWTP(model(i),
      init,
      COPositionBaseSMTWTP,
      PermutationSwap,
      mutation,
      nbGeneration,
      PermutationSMTPWTPFitness)
    val timeElapsed = (System.currentTimeMillis() - time)

    val scores = population.map { p => PermutationSMTPWTPFitness(p, model(i)) }

    val str = scores.min + "\t" + timeElapsed + "\t" + PermutationSMTPWTPFitness.counter + "\n"
    Logger.write(str)
    print("\t" + str)
    PermutationSMTPWTPFitness.counter = 0
  }

  Logger.close()

}