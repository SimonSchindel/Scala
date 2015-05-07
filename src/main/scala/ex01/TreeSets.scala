package ex01

object TreeSets {

  abstract class IntSet {
    def incl(x: Int): IntSet
    def contains(x: Int): Boolean

    def foreach(f: Int => Unit)
    def filter(p: Int => Boolean): IntSet = {
      var out: IntSet = Empty
      foreach({i => if (p(i)) out = out.incl(i)})
      out
    }
    def intersect(that: IntSet): IntSet = {
      var out: IntSet = Empty
      foreach({i =>
        if(that.filter({j => j==i}).isInstanceOf[NonEmpty]){
          out = out.incl(i)
        }})
      out
    }
    
    override def toString: String = {
      var out = ""
      foreach({i => out += i + " "})
      out
    }
  }

  case object Empty extends IntSet {
    def contains(x: Int): Boolean = false
    def incl(x: Int): IntSet = NonEmpty(x, Empty, Empty)
    def foreach(f: Int => Unit) {f}
  }


  case class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    def contains(x: Int): Boolean = {
      var out = false
      foreach({i => if (i == x) out = true})
      out
    }
      
    def incl(x: Int): IntSet = {
      if (x < elem) {
        if (left.isInstanceOf[NonEmpty]) {
          NonEmpty(elem, left.incl(x), right)
        }
        else {
          NonEmpty(elem, NonEmpty(x, Empty, Empty), right)
        }
      } else {
        if (right.isInstanceOf[NonEmpty]) {
          NonEmpty(elem, left, right.incl(x))
        }
        else {
          NonEmpty(elem, left, NonEmpty(x, Empty, Empty))
        }
      }
    }

    def foreach(f: Int => Unit) {
      f(elem)
      if (left.isInstanceOf[NonEmpty]){
        left.foreach(f)
      }
      if (right.isInstanceOf[NonEmpty]) {
          right.foreach(f)
      }
    }
  }

  // incl and contains as functions:
  def incl(s: IntSet, x: Int): IntSet = s.incl(x) // TODO: replace this

  def contains(s: IntSet, x: Int): Boolean = s.contains(x) // TODO: replace this

  def main(args: Array[String]) {
    println("TreeSets implementation:")
    
    // add main implementation here, can be run with sbt run
  }
}

