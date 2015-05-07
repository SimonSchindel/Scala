package ex01

import org.scalatest._
import ex01.TreeSets._

class TreeSetsTests extends FlatSpec with Matchers {
  val testSet = Empty.incl(1).incl(2).incl(3).incl(4)
  val testSet2 = Empty.incl(2).incl(5).incl(6)
  
  "Empty set" should "contain nothing" in {
    for (i <- -1000 to 1000) Empty.contains(i) should equal (false)
  }
  
  "One element set" should "contain its value" in {
    for (i <- -1000 to 1000) Empty.incl(i).contains(i) should equal (true)
  }
  
  "{1, 2, 3, 4}" should "contain 2" in {
    testSet.contains(2) should equal (true)
  }
  
  "{1, 2, 3, 4}" should "not contain 10" in {
    testSet.contains(10) should equal (false)
  }
  
  "{1, 2, 3, 4}.foreach" should "be called on each element" in {
    var callNo = 0
    testSet.foreach { i => callNo += 1 }
    callNo should equal (4)
  }
  
  "{1, 2, 3, 4}.foreach" should  "be called in the right order" in {
    var no = 0
    testSet.foreach { i => no += 1; no should equal (i) }
  }
  
  "Empty.foreach" should "never call lambda" in {
    Empty.foreach { i => fail("reached inner lambda of empty foreach") }
  }
  
  "{1,2,3,4}.filter { x -> false }" should "return the Empty set" in {
    testSet.filter { x => false } should equal (Empty)
  }
  
  "{1,2,3,4}.filter {x -> even(x) }" should "return {2,4}" in {
    testSet.filter { x => x % 2 == 0 } should equal (Empty.incl(2).incl(4))
  }
  
  "{1,2,3,4}.intersect({2,5,6})" should "return {2}" in {
    testSet.intersect(testSet2) should equal (Empty.incl(2))
  }
  
  //test incl and contains functions
  "incl(Empty, 2)" should "equal Empty.incl(2)" in {
    incl(Empty,2) should equal (Empty.incl(2))
  }
  
  "incl({1,2,3,4}, 5)" should "equal {1,2,3,4,5}" in {
    incl(testSet, 5) should equal (testSet.incl(5))
  }
  
  "toString" should "work correctly" in {
    testSet.toString should equal ("1 2 3 4 ")
  }
}