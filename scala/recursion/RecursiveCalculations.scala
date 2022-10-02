package basics.recursion

object RecursiveCalculations extends App{

  def countDown(n: Int): Unit ={
    if(n >= 0) {
      println(n)
      countDown(n-1)
    }
  }

  def factorial(n: Int): Long = {
    if (n> 1)
      n*factorial(n-1)
    else 1
  }


  countDown(8)
  factorial(5)


  def code(args: Array[String]): Unit = {
    val lista = List(1,2,4,5,8)

    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case x :: tail => x + sum(tail)
    }

    def sum2(ints: List[Int]): Int = {
      def sumAccumulator(ints: List[Int], accum: Int): Int = {
        ints match {
          case Nil => accum
          case x :: tail => sumAccumulator(tail, accum + x)
        }
      }
      sumAccumulator(ints, 0)
    }

    def sum3(xs: List[Int]): Int = {
      if (xs.isEmpty) 0
      else xs.head + sum3(xs.tail)
    }

    sum(lista)
    sum2(lista)
    sum3(lista)

    def sumWithReduce(ints: List[Int]) = {
      ints.reduceLeft(_+_)
    }

    sumWithReduce(lista)

  }

  def countDown2(n: Int): Unit = {
    if(n>0){
      println(n)
      countDown2(n-1)
    }
  }

  def countUp(n: Int): Unit = {
    if(n > 0){
      countUp(n-1)
      println(n)
    }
  }

}
