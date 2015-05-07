package ex01

import org.scalatest._
import ex01.FunctionSets._

class FunctionSetsTests extends FlatSpec with Matchers {
  val s = union(union(Set(3), Set(1)), Set(4))
  val t = union(Set(2), Set(4))
  
   "union(union(Set(3), Set(1)), Set(4))" should "print to {1,3,4}" in {
     setToString(s) should equal ("{1,3,4}")
   }
  
  "Set(i)" should "contain i" in {
    for (i <- -1000 to 1000) contains(Set(i), i) should equal (true)
  }
  
  "Set(i)" should "not contain any other number" in {
    for (i <- -1000 to 1000; j <- -1000 to 1000; if (i != j)) contains(Set(i), j) should equal (false)
  }
  
  "intersect({1,3,4},{2,4})" should "equal {4}" in {
    setToString(intersect(s, t)) should equal ("{4}")
  }
  
  "filter({1,3,4}, x => x > 2)" should "equal {3,4}" in {
    setToString(filter(s, x => x > 2)) should equal ("{3,4}")
  }
  
  "forall({1,3,4}, x => x > 0)" should "be true" in {
    forall(s, x => x > 0) should be (true)
  }
  
  "forall({1,3,4}, x => x > 1)" should "be false" in {
    forall(s, x => x > 1) should be (false)
  }
  
  "exists({1,3,4}, x => x > 1" should "be true" in {
    exists(s, x => x > 1) should be (true)
  }
}