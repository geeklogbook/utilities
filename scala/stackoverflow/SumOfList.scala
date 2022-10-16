package stackoverflow

object SumOfList {

  def main(args: Array[String]): Unit = {

    def sum(xs: List[Int]): Int = {
      if (xs.isEmpty) {
        0
      } else {
        xs.head + sum(xs.tail)
      }
    }

    println(sum(List(1,2,3)))

  }
}
