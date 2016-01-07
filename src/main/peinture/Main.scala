package main.peinture

object Main extends App {
  
  val instrPaint1 = new solution.peinture.PaintInstr(1,1,1)
  val instrErase1 = new solution.peinture.EraseInstr(0,1)
  
  val solution1 = new solution.peinture.Instructions(List(instrPaint1, instrErase1))
  
  println(solution1.eval)
  
}