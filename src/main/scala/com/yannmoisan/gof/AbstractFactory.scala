package com.yannmoisan.gof

import scala.collection.mutable

/**
 * Scala implementation of : https://github.com/forax/design-pattern-reloaded/blob/master/src/abstractfactory/abstractfactory3.java
 */
object AbstractFactory extends App {
  sealed trait Vehicle
  case class Car() extends Vehicle
  case class Moto() extends Vehicle

  class VehicleFactory[T] {
    val map = mutable.Map[String, () => T]().withDefault(name => () => throw new IllegalArgumentException(s"Key '$name' not registered") )
    def register(name: String, f: () => T) = map.put(name, f)
    def create(name: String) = map(name)()
  }

  val factory = new VehicleFactory[Vehicle]()
  factory.register("car", Car.apply)
  factory.register("moto", Moto.apply)

  val vehicle1 = factory.create("car")
  System.out.println(vehicle1)
  val vehicle2 = factory.create("moto")
  System.out.println(vehicle2)
}
