package crossover

import solution.Permutation

object COPositionBaseSMTWTP extends AbstractCrossOver[Permutation] {
  
   override def apply(parent1: Permutation, parent2: Permutation) : List[Permutation] = {
     
     val size = parent1.permutation.size / 2
     val indices = scala.util.Random.shuffle((parent1.permutation.indices).toList)
     
     val indices1 = indices.dropRight(size)
     val indices2 = indices.drop(size)
     
     buildChildren(parent1,parent2, indices1, indices2)
   }
   
   private def buildChildren(parent1: Permutation, 
       parent2: Permutation, 
       indices1 : List[Int],
       indices2 : List[Int],
       children : (List[Int],List[Int]) = (Nil,Nil),
       index : Int = 0) : List[Permutation] = {
     if (index == indices1.length)
       List(new Permutation(children._1), new Permutation(children._2))
     else {
       buildChildren(parent1,parent2,indices1,indices2,
           (children._1 :+ parent1(indices1(index)) :+ parent2(indices2(index)),
       children._2 :+ parent2(indices1(index)) :+ parent1(indices2(index)))
       , index + 1)
     }
   }
  
}