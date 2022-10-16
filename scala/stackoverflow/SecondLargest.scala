package stackoverflow

object SecondLargest {

  def secondLargest[A: Ordering](as: Seq[A]): Option[A] = {
    val bottom = Option.empty[A]
    val ord = implicitly[Ordering[Option[A]]]

    import ord._

    as.foldLeft((bottom, bottom)){
      case((largest, second), x) =>
        val wrapped = Some(x)
        if(wrapped > largest)(wrapped, largest)
        else if (wrapped > second)(largest, wrapped)
        else(largest, second)
    }._2
  }

  def secondSmallest[A: Ordering](as: Seq[A]): Option[A] =
    secondLargest(as)(implicitly[Ordering[A]].reverse)

  def main(args: Array[String]): Unit = {

    println(secondLargest(Seq("foo", "bar", "baz")))
    println(secondLargest(Seq(4, 7, 2, 5, 9, 6, 4)))
    println()
    println(secondSmallest(Seq("aa", "ca", "ab", "bc", "cc")))
    println(secondSmallest(Seq(4, 7, 2, 5, 9, 6, 4)))
  }

}
