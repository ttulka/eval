package cz.net21.ttulka.scala.akka.maven.hello

import akka.actor.Actor
import akka.actor.Props

class HelloWorld extends Actor{       
  
  override def preStart(): Unit = {
    // create the greeter actor
    val greeter = context.actorOf(Props[Greeter], "greeter")
    // tell it to perform the greeting
    println("Running a Greeter.") 
    greeter ! Greeter.Greet
  }

  def receive = {
    // when the greeter is done, stop this actor and with it the application
    case Greeter.Done =>
      println("Greeter done.") 
      context.stop(self)
  }
}
