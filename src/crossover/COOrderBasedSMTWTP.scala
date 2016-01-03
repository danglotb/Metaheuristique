package crossover

import solution.Permutation

object COOrderBasedSMTWTP extends AbstractCrossOver[Permutation] {

  override def apply(parent1: Permutation, parent2: Permutation): List[Permutation] = {

    val size = (parent1.permutation.length) / 2

    val randomOffset = new java.util.Random().nextInt(size / 2 + 1)

    val middle1 = parent1.permutation.slice((size / 2) + randomOffset, size + (size / 2) + randomOffset)
    val middle2 = parent2.permutation.slice((size / 2) + randomOffset, size + (size / 2) + randomOffset)
    
    List(new Permutation(build(middle1, parent2.permutation)), new Permutation(build(middle2, parent1.permutation)))
  }

  private def build(slice: List[Int],
            parent: List[Int],
            child: List[Int] = Nil): List[Int] = {
    if (slice.isEmpty && parent.isEmpty)
      child
    else {
      if (slice.contains(parent.head))
        build(slice.tail, parent.diff(List(slice.head)), child :+ slice.head)
      else
        build(slice, parent.tail, child :+ parent.head)
    }
  }

}