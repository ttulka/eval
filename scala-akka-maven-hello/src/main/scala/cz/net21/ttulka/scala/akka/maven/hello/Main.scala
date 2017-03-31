package cz.net21.ttulka.scala.akka.maven.hello;

object Main {
  def main(args: Array[String]): Unit = {
    akka.Main.main(Array(classOf[HelloWorld].getName))
  }
}
