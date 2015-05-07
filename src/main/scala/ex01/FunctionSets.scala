package ex01

object FunctionSets {
  /**
   * This type alias defines how sets are represented.
   */
  type Set = Int => Boolean

  /**
   * This function tests whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  def Set(elem: Int): Set = ???

  def union(s: Set, t: Set): Set = ???
  def intersect(s: Set, t: Set): Set = ???
  def diff(s: Set, t: Set): Set = ???

  def filter(s: Set, p: Int => Boolean): Set =
    ???

  def forall(s: Set, p: Int => Boolean): Boolean = {
    ???
  }

  def exists(s: Set, p: Int => Boolean): Boolean =
    ???

  def map(s: Set, f: Int => Int): Set =
    ???

  /**
   * This function displays the contents of a set in a string.
   */
  def setToString(s: Set): String = {
    ???
  }

  /**
   * This function prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(setToString(s))
  }

  def main(args: Array[String]) {
    println("FunctionSets implementation:")
    
    // add main implementation here, can be run with sbt run
  }
}