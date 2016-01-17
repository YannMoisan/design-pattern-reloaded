package com.yannmoisan.gof

/**
  * Scala implementation of https://github.com/forax/design-pattern-reloaded/blob/master/src/visitor/visitor5.java
  */
object Visitor2 extends App {

  sealed trait Vehicle
  case class Car() extends Vehicle
  case class Moto() extends Vehicle

  trait Callable[S] {
    def call(s: S) : String
  }

  implicit val carCallable = new Callable[Car] {
    override def call(s: Car): String = "car"
  }

  implicit val motoCallable = new Callable[Moto] {
    override def call(s: Moto): String = "moto"
  }

  def call[S : Callable](s: S) = implicitly[Callable[S]].call(s)

  val vehicle = new Car()
  val text = call(vehicle)
  System.out.println(text)

}
