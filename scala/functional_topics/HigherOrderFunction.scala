package basics.functions

object HigherOrderFunction {

  def id(x: Int): Int = x
  def cube(x: Int): Int = x * x * x
  def fact(x: Int): Int = if(x==0) 1 else fact(x - 1)

  println("Functions")
  def sumInts(a: Int, b: Int): Int = {
    if(a > b) 0 else a + sumInts(a+1,b)
  }

  def sumCubes(a: Int, b: Int): Int = {
    if(a > b) 0 else cube(a) + sumCubes(a+1, b)
  }
  println("Sum with higher-order basics.functions")
  def sum(f: Int => Int, a: Int, b:Int): Int = {
    if(a > b) 0 else f(a) + sum(f, a+1, b)
  }

  def sumIntsHo(a:Int, b: Int): Int = sum(id, a ,b)
  def sumCubesHo(a: Int, b: Int): Int = sum(cube,a,b)
  def sumFactorials(a:Int, b: Int): Int = sum(fact,a,b)

  //Anonymous basics.functions are sintactic sugar

  def SumIntsAn(a: Int, b: Int): Int = sum(x => x,a,b)
  def sumCubesAn(a:Int, b: Int):Int = sum(x => x*x*x, a,b)

  //Tail-recursive Function

  def sumTailRerc(f:Int => Int, a: Int, b:Int): Int = {
    def loop(a: Int, acc:Int): Int = {
      if(a >b) acc else loop(a+1, f(a)+ acc)
    }
    loop(a,0)
  }

  sum(x=>x,1,10)


}
