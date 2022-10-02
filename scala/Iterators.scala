package algorithms.datastructures.collections

object IteratorGenerator {

  def main(args: Array[String]): Unit = {
    println("Hello World")

    case class UserEvent(id: Int, url: String)

    val event1: UserEvent = UserEvent(1, "Url1")
    val event2: UserEvent = UserEvent(2, "Url2")
    val event3: UserEvent = UserEvent(3, "Url3")

    val eventIterator: Iterator[UserEvent] = Iterator(event1, event2, event3)
    //println(eventIterator.length)

    val eventUrls: Iterator[String] = eventIterator.map(
      userEvent =>{userEvent.url}
    )

    eventUrls.foreach(println)


    println(eventUrls.length)
  }

}
