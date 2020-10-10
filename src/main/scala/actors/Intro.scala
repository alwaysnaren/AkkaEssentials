package actors

import akka.actor.{Actor, ActorSystem, Props}

object Intro extends App {

  val actorSys = ActorSystem("learning")

  val wordCounter = actorSys.actorOf(Props[WordCounter], "wordCounter")

  wordCounter ! "Hello Naren"
  wordCounter ! "what's next, learning?"

  class Counter extends Actor {
    var count = 0
    override def receive: Receive = {
      case Increment(n) => count += n
      case Decrement(n) => count -= n
      case Print => println(s"[Count] is $count")
    }
  }

  object Print
  case class Increment(n: Int)
  case class Decrement(n: Int)

  val counter = actorSys.actorOf(Props[Counter], "counter")
  counter ! Increment(23)
  counter ! Increment(23)
  counter ! Increment(23)
  counter ! Increment(337223)
  counter ! Increment(23)
  counter ! Decrement(23)
  counter ! Increment(23)
  counter ! Decrement(242233)
  counter ! Print

//  class BankAcc(name: String) extends Actor {
//    override def receive: Receive = {
//      case
////    }
//  }

  case class Deposit(n: Double)
  case class WithDraw(n: Double)




}
