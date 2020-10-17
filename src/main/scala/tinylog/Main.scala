package tinylog

import scala.collection.immutable.BitSet
import scala.collection.immutable.HashMap
import scala.collection.immutable.HashSet

import scribe.format.Formatter
import scribe.format.message
import scribe.format.FormatterInterpolator
import scribe.Logger
import scribe.format.dateFull
import scribe.format.gray
import scribe.format.green
import scribe.format.levelColoredPaddedRight
import scribe.format.mdc
import scribe.format.string
import scribe.format.threadNameAbbreviated
import scribe.format.FormatBlock
import scribe.Level
import scribe.format.className
import scribe.format.positionAbbreviated

import tinylog.test.TestClass

object Main {

  // format: off
  lazy val myFormatter: Formatter =
    formatter"$dateFull ${string("[")}$levelColoredPaddedRight${string("]")} $threadNameAbbreviated ${green(positionAbbreviated)} - ${gray(message)}$mdc"
  // format: on

  def myPositionAbbreviated: FormatBlock =
    className.abbreviate(maxLength = 10, padded = true, abbreviateName = true)

  Logger.root
    .clearHandlers()
    .withHandler(formatter = myFormatter, minimumLevel = Some(Level.Info))
    .replace()

  /**
    * hhhssss
    * @param args
    */
  def main(args: Array[String]): Unit = {
    scribe.trace("starting...")

    scribe.info("Hello World!")
    scribe.debug("Multiple lines\nFirst line\n\tLine with tabs\nAnother line")

    val fruit: List[String] = List("apples", "oranges", "pears")
    scribe.info(fruit.toString())
    val nums: List[Int] = List(1, 2, 3, 4)
    scribe.info(nums.toString())
    val empty: List[Nothing] = List()
    scribe.info(empty)
    val dim: List[List[Int]] =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )
    scribe.info(dim.toString())
    val e = email("earl.dombowsky", "hitachi-powergrids.com")
    scribe.info(e.toString)
    val v = None
    scribe.info(v.toString)
    val v1 = Some(12)
    scribe.info(v1.toString)

    var z = Array("Zara", "Nuha", "Ayan")
    scribe.info(z.toString)

    val colorus =
      HashMap("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    scribe.debug(colorus.toString())

    val vec: Vector[String] = Vector("Zara", "Nuha", "Ayan")
    scribe.debug(vec.toString)

    var bs: BitSet = BitSet(0, 1, 2)
    scribe.info(bs.toString())

    val hs: HashSet[String] = HashSet("Zara", "Nuha", "Ayan")
    scribe.info(hs.toString())

    val seq: Seq[Int] = Seq(1, 2, 3, 4, 5)
    scribe.info(seq.toString())

    val e1 = email("a", "b.com")
    val e2 = email("a", "b.com")
    val e3 = email("a", "b.com")
    val em = List(e1, e2, e3)
    scribe.info(em.toString())

    scribe.warn("Caught", new IllegalArgumentException("missing parameter"))
    scribe.error("Caught", new IllegalArgumentException("missing parameter"))

    val testClass = new TestClass
    testClass.sayHello("Bob")

    scribe.trace("ending...")
  }

  case class email(name: String, domain: String)
}
