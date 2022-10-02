package basics

object ElementFromSublist extends App{

  val alco = List(
                ("Light Beer", "4%", "23 OZ"),
                ("Regular Beer", "6%", "23 OZ"))

  val temp2 = alco.head._1
  println(temp2)
}
