package cz.net21.ttulka.scala.akka.maven.hello

import akka.actor.Actor

object Greeter {
  case object Greet
  case object Done
}

class Greeter extends Actor {
  def receive = {
    case Greeter.Greet =>
      println(this.getClass.getSimpleName + " says: Hello Akka!")
      sender() ! Greeter.Done
  }
}
