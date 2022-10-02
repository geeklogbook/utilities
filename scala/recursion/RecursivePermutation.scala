package basics.recursion

object RecursivePermutation extends App{

  def permute(nums: List[Int], f: List[Int] => Unit, p:List[Int]):Unit = {
    if(nums.isEmpty){
      f(p)
    } else {
      var before = List[Int]()
      var after  = nums
      while (after.nonEmpty){
        permute(before:::after.tail, f, after.head::p)
        before ::= after.head
        after = after.tail
      }
    }
  }

  permute(List(1,2,3,4), println, Nil)



  def permutations(lst:List[Int]):List[List[Int]] = lst match {
    case Nil => List(Nil)
    case List(1) => List(lst)
    case _ =>
      (for(i <- lst.indices.toList) yield {
        val (before, rest) = lst.splitAt(i)
        val elem = rest.head
        val subpermutes = permutations(before ++ rest.tail)
        subpermutes.map(elem::_)
      }).flatten
  }

}
