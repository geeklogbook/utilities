package basics.maps

object PrintInFormattedWay extends App {

  val k = Array(Array("s", "2", "20"), Array("sw", "3", "3"))

  println(k.map(_.mkString("[", ", ", "]")).mkString("[", ", ", "]"))

}
