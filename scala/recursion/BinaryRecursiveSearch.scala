package basics.recursion

case object BinaryRecursiveSearch extends App {

  def busquedaBinaria[A](x:A, xs:Array[A])(implicit ord: Ordering[A]): Option[Int] = {
    import ord._

    def buscar(izq: Int, der: Int): Option[Int] = {
      if (izq > der) {
        None
      } else {
        val cen = (izq + der) / 2
        val y = xs(cen)
        if(x == y){
          Some(cen)
        } else if (x < y){
          buscar(izq, cen-1)
          } else {
          buscar(cen+1,der)
        }
      }
    }
    buscar(0,xs.length-1)
  }

  println("Hola")
  val arrayABuscar = Array[Int](1,8,12,25,26,30,80,90,99,100)
  println(busquedaBinaria(30,arrayABuscar))
  println(busquedaBinaria(31,arrayABuscar))
}
