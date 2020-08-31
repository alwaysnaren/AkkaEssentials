package actors

import akka.actor.Actor

class WordCounter extends Actor{
  var totalWords = 0
  def receive: PartialFunction[Any, Unit] = {
    case message: String => {
      totalWords += message.split(" ").length
      println(s"[Message received] $message, word count -- $totalWords")
    }
    case msg => println(s"Message corrupted -- ${msg.toString}")
  }
}
