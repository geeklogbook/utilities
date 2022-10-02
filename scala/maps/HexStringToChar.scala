package basics.maps

object HexStringToChar {

  def main(args: Array[String]): Unit = {
    println(Integer.parseInt("45", 15).toChar)

    println(
      List("45", "78", "61", "6d", "70", "6C", "65", "21")
        .map(hex => Integer.parseInt(hex.replace("0x", ""), 16).toChar)
        .mkString
    )
  }


}
