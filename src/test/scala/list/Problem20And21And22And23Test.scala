package list

import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}

import list.Problem20and21and22and23._

/*
* @author owie 12/2/15
*
*/
class Problem20And21And22And23Test extends FlatSpec with PropertyChecks with Matchers {

  "removeAt" should "removeAt" in {
    val ls = removeAt(1, List('a, 'b, 'c, 'd))
    ls should be(List('a, 'c, 'd), 'b)
  }

  it should "throw exception when index removeAt > list length" in {
    a[IllegalArgumentException] should be thrownBy {
      removeAt(3, List('a, 'b))
    }
  }

  "insertAt" should "insertAt" in {
    val ls = insertAt('new, 1, List('a, 'b, 'c, 'd))
    ls should be(List('a, 'new, 'b, 'c, 'd))
  }

  it should "throw exception when index insertAt > list length" in {
    a[IllegalArgumentException] should be thrownBy {
      insertAt('new, 2, List('a, 'b))
    }
  }

  "range" should "range" in {
    val ls = range(4, 9)
    ls should be(List(4, 5, 6, 7, 8, 9))
  }

  it should "range when from = to" in {
    val ls = range(4, 4)
    ls should be(List(4))
  }

  it should "throw error when from <= to" in {
    a[IllegalArgumentException] should be thrownBy {
      range(9, 4)
    }
  }

  "randomSelect" should "randomSelect" in {
    val origList = List('a, 'b, 'c, 'd, 'f, 'g, 'h)
    val ls = randomSelect(3, origList)
    ls.length should be(3)
    ls.distinct.length should be(3)
    ls foreach {
      elem => origList should contain(elem)
    }
  }
}
