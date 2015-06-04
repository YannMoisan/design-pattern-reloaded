package com.yannmoisan.gof

/**
 * Scala implementation of : https://github.com/forax/design-pattern-reloaded/blob/master/src/logger/logger6.java
 */
object Loggers extends App {
  type Logger = String => Unit

  def filter(logger: Logger, predicate: String => Boolean): Logger =
    s => if (predicate(s)) { logger(s) }

  val logger: Logger = s => println(s)
  logger("hello")

  val filterLogger = filter(logger, s => s.startsWith("hell"))
  filterLogger("hello")
  filterLogger("ok")
}
