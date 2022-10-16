
//Inspired In: https://stackoverflow.com/questions/74077006/print-array-with-different-deep 

object printAnyFunctiont extends App{
    val listTest = Array(5,"h",Array(1.5,2), "b", 2)
    val listTestInt = Array(5, 2)

    def printA(A: Array[_]): Unit = {
        A match {
            case A: Array[Int]=> A.foreach(println)
            case _ => A.foreach(printA)
        }
    }


    printA(listTest)
    printA(listTestInt)
    println("Hello")
}

