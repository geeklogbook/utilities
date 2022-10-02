package algorithms.datastructures

object TupleDemo extends App {
  val myTuple = (12, "a string")

  val twelve = myTuple._1
  println(twelve)

  val aString = myTuple._2
  println(aString)

  def combine(firstTuple: (Double, String), secondTuple: (Double, String)): (Double, String) = {
    (firstTuple._1 + secondTuple._1, firstTuple._2 + secondTuple._2)
  }

  println(combine((1.0, "Hello"), (2.0, "world")))

  def sumAll(a: Int, b: Int, c: Int): Int = a + b +c
  val input = (12, 5, 6)

  println((sumAll _).tupled(input))

}
