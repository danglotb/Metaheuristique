package crossover

import solution.Permutation

object COPositionBaseSMTWTP extends AbstractCrossOver[Permutation] {

  override def apply(parent1: Permutation, parent2: Permutation): List[Permutation] = {

    val size = parent1.permutation.size / 2
    val indices = (scala.util.Random.shuffle((parent1.permutation.indices).toList)).dropRight(size).sortBy { x => x }

    List(buildChild(parent1.permutation, parent2.permutation.diff(build(parent1, indices)), indices),
      buildChild(parent2.permutation, parent1.permutation.diff(build(parent2, indices)), indices))
  }

  private def buildChild(parent1: List[Int],
                         elemOfParent2: List[Int],
                         indices: List[Int],
                         index: Int = 0,
                         child: List[Int] = Nil): Permutation = {
    if (index == parent1.length)
      new Permutation(child)
    else {
      if (indices.contains(index)) {
        buildChild(parent1, elemOfParent2, indices, index + 1, child :+ parent1(index))
      } else
        buildChild(parent1, elemOfParent2.tail, indices, index + 1, child :+ elemOfParent2.head)
    }
  }

  private def build(parent: Permutation,
                    indices: List[Int],
                    child: List[Int] = Nil): List[Int] = {
    if (indices.isEmpty)
      child
    else
      build(parent, indices.tail, child :+ parent(indices.head))
  }
}