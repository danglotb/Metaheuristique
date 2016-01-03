package main

import heuristiques.MTSPRandomHeuristique
import model.MTSPModel
import fitness._
import solution.Permutation
import filter.PermutationMTSPFilter
import neighbors._
import localsearch._

object BenshMO extends App {

  val path = List("data/randomA100.tsp", "data/randomB100.tsp")

  val model = input.MTSPReader(path)

  val nbInit = 100

  for (i <- 0 until 10) {
    val init = PermutationMTSPFilter.buildRandomInstance(model, nbInit)
    mainHybrid(init, i)
    mainScalar(init, i)
    mainPareto(init, i)
  }

  def mainHybrid(initl: List[Permutation], z: Int) = {

    val path = List("data/randomA100.tsp", "data/randomB100.tsp")

    val model = input.MTSPReader(path)

    val nbInit = 1

    val initPareto = PermutationMTSPFilter.buildRandomInstance(model, 1)

    util.Logger.open("out/hybrid/alone_time")

    val timeGiven = 1000000

    val time = System.currentTimeMillis()

    def timeOut() = System.currentTimeMillis() - time > timeGiven

    val pareto = HybridParetoScalarMTSPSearch(model,
      initPareto,
      Permutation2Opt,
      timeOut)

    util.Logger.write((System.currentTimeMillis() - time) + "\n")

    val scoresPareto = (PermutationMTSPFitness.computeAllScores(
      PermutationMTSPFilter(pareto, model), model)).sortBy { x => x(0) }

    var str = ""

    scoresPareto.foreach { score =>
      score.foreach { s =>
        str += s + "\t"
      }
      str += "\n"
    }

    util.Logger.write("out/hybrid/alone", str)

    util.Logger.close

  }

  def mainScalar(initl: List[Permutation], z: Int): Unit = {

    val weigths = PermutationScalarMTSPFitness.buildWeigth2D(0.0, 2000.0, 1)

    val init = initl.head

    val timeGiven = 1000000

    val time = System.currentTimeMillis()

    def timeOut() = (System.currentTimeMillis() - time) > timeGiven

    val firstFitness = PermutationScalarMTSPFitness(
      PermutationMTSPFitness,
      weigths.head,
      init,
      model)

    val scalar = BestScalarMTSPSearch(init,
      firstFitness,
      model,
      List(Permutation2Opt),
      Permutation2Opt(init),
      PermutationMTSPFitness,
      weigths,
      timeOut)

    println((System.currentTimeMillis() - time) + " ms for scalar")

    val scoresScalar = (PermutationMTSPFitness.computeAllScores(
      PermutationMTSPFilter(scalar, model), model)).sortBy { x => x(0) }

    var str = ""

    scoresScalar.foreach { score =>
      score.foreach { s =>
        str += s + "\t"
      }
      str += "\n"
    }

    util.Logger.write("out/scalar/2opt_100_0.1_" + z, str)

  }

  def mainPareto(init: List[Permutation], z: Int): Unit = {

    val path = List("data/randomA100.tsp", "data/randomB100.tsp")

    val model = input.MTSPReader(path)

    val nbInit = 1

    val initPareto = init

    util.Logger.open("out/pfront/time")

    val timeGiven = 1000000

    val time = System.currentTimeMillis()

    def timeOut() = System.currentTimeMillis() - time > timeGiven

    val pareto = ParetoMTSPSearch(model,
      initPareto,
      Permutation2Opt,
      timeOut)

    util.Logger.write(z + "\t" + nbInit + "\t" + (System.currentTimeMillis() - time) + "\n")

    val scoresPareto = (PermutationMTSPFitness.computeAllScores(
      PermutationMTSPFilter(pareto, model), model)).sortBy { x => x(0) }

    var str = ""

    scoresPareto.foreach { score =>
      score.foreach { s =>
        str += s + "\t"
      }
      str += "\n"
    }

    util.Logger.write("out/pfront/2opt_time_" + timeGiven + "_" + z, str)

    util.Logger.close

  }
}
