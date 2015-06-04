package com.yannmoisan.gof

import scala.collection.mutable

/**
 * Scala implementation of https://github.com/forax/design-pattern-reloaded/blob/master/src/visitor/visitor5.java
 */
object Visitor extends App {

  sealed trait Vehicle
  case class Car() extends Vehicle
  case class Moto() extends Vehicle

  class Visitor[O] {
    val pfs = new mutable.ArrayBuffer[PartialFunction[Vehicle, O]]

    def when(pf: PartialFunction[Vehicle, O]) = pfs += pf

    def call(v: Vehicle) = pfs.reduce((a, b) => a.orElse(b)).apply(v)
  }

  val visitor = new Visitor[String]()
  visitor.when { case c: Car => "car" }
  visitor.when { case m: Moto => "moto" }


  val vehicle = new Car()
  val text = visitor.call(vehicle)
  System.out.println(text)

}
