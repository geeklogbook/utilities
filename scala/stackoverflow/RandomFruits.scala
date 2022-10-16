package stackoverflow

import org.scalacheck._

object RandomFruits {

  def main(args: Array[String]): Unit = {

    fruits.foreach(println)

  }

  final case class Fruit(name: String, origin:String)
  val originGen: Gen[String] = Gen.oneOf(List("apple", "banana", "orange", "strawberry"))
  val fruitNameGen: Gen[String] = Gen.oneOf(List("USA", "Spain", "France", "Sweden", "México"))

  val fruits: Seq[Fruit] = {
    for {
      _ <- 0 to 10
      origin <- originGen.sample.take(1)
      fruit <- fruitNameGen.sample.take(1)
    } yield Fruit(fruit, origin)
  }
}


