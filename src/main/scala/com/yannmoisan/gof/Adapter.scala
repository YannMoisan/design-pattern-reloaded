package com.yannmoisan.gof

/**
 * Scala implementation of : https://github.com/forax/design-pattern-reloaded/blob/master/src/adapter/adapter2.java
 */
object Adapters extends App {
  sealed trait Level
  case object WARNING extends Level
  case object ERROR extends Level

  type Logger = String => Unit
  type Logger2 = (Level, String) => Unit

  val logger2 : Logger2 = (level, msg) => println(level + " " + msg)
  logger2(ERROR, "abort abort !")
  logger2.curried(ERROR)("abort abort !")

}