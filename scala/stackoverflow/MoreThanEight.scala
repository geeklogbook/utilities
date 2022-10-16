package stackoverflow

object MoreThanEight {
  def main(args: Array[String]) = {
    val names=List("sachinramesh","rahuldravid","viratkohli","mayank")

    def moreThanEight(names: List[String]): List[String] = {
      names.collect {
        case s if s.lengthCompare(8) > 0 && s.contains('r') =>
          s.toUpperCase
      }
    }

    val testNames = moreThanEight(names)
    print(testNames)
  }
}
