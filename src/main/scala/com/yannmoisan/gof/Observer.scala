package com.yannmoisan.gof

import java.nio.file.{Paths, Path}

import scala.io.Source

/**
 * Scala implementation of : https://github.com/forax/design-pattern-reloaded/blob/master/src/observer/observer3.java
 */
object Observer extends App {
  def parse(path: Path, observer: Double => Unit) = {
    Source.fromFile(path.toFile)
          .getLines()
          .flatMap(_.split(","))
          .map(_.toDouble)
          .foreach(observer)
  }

  var sum = 0d
  val path = Paths.get("/Users/yamo/Projects/sandbox-scala/src/main/resources/test.csv")
  parse(path, d => {sum = sum + d; Unit})
  println(sum)
}
