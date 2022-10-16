package stackoverflow

object Notification {

  def main(args: Array[String]): Unit = {
    println("*" * 150)

    println(showNotification(someSms))
    println(showNotification(someVoiceRecording))

    println("*" * 150)
  }



  abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification
  case class SMS(caller: String, message: String) extends Notification
  case class VoiceRecording(contactName: String, link: String) extends Notification

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(email, title, _) =>
        s"You got an email from $email with title: $title"
      case SMS(number, message) =>
        s"you received an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"you received a Voice Recording from $name! Click the link to hear it: $link"
      case _ => "No notification"
    }
  }

  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom","voicerecording./blablabla")

  println(showNotification(someSms))
  println(showNotification(someVoiceRecording))



}
