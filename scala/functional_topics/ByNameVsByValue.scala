package basics.functions

object ByNameVsByValue {

  def main(args: Array[String]): Unit = {

    def time(): Long = {
      println("In time()")
      System.nanoTime
    }

    println("BY VALUE")

    def execValue(t: Long): Long = {
      println("Entered exec, calling t ...")
      println("t = " + t)
      println("Calling t again ...")
      t
    }

    println(execValue(time()))
    println()
    println("BY NAME")

    // `t` is now defined as a by-name parameter
    def execName(t: => Long) = {
      println("Entered exec, calling t ...")
      println("t = " + t)
      println("Calling t again ...")
      t
    }

    println(execName(time()))

  }



}
