package crossover

import solution.Permutation

object COOrderBasedSMTWTP extends AbstractCrossOver[Permutation] {

  override def apply(parent1: Permutation, parent2: Permutation) : List[Permutation] = {

    val size = (parent1.permutation.length) / 2
    
    val randomOffset = new java.util.Random().nextInt(size/2)

    val front1 = parent2.permutation.slice(0, (size / 2) + randomOffset)
    val middle1 = parent1.permutation.slice((size / 2) + randomOffset, size + (size / 2) + randomOffset)
    val back1 = parent2.permutation.slice(size + (size / 2) + randomOffset, size * 2)

    val front2 = parent1.permutation.slice(0, (size / 2) + randomOffset)
    val middle2 = parent2.permutation.slice((size / 2)+ randomOffset, size + (size / 2) + randomOffset)
    val back2 = parent1.permutation.slice(size + (size / 2) + randomOffset, size * 2)

    List(new Permutation(front1 ++ middle1 ++ back1),new Permutation(front2 ++ middle2 ++ back2))
  }

}