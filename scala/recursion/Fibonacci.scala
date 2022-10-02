package basics.recursion

object Fibonacci extends App{

  def fib(n: Long): Long = if(n < 2) 1 else fib(n-1) + fib(n-2)

  println(fib(6))

  def fibLoop(n:Long): Long = {
    if(n<2) 1 else {
      var (a,b) = (1L,1L)
      var c = a + b
      for (i <- 2L until n){
        a = b
        b = c
        c = a + b
      }
      c
    }
  }

  println(fibLoop(6))

  def fibRecur(n:Long):Long = {
    def helper(n:Long, a:Long,b:Long):Long = if(n<=0) a + b else helper(n-1,b,a+b)
    if(n<2) 1 else helper(n-2,1,1)
  }

  println(fibRecur(6))



}
