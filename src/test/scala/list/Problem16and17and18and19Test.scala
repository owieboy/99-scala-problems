package list

import org.scalatest.prop.PropertyChecks
import org.scalatest.{Matchers, FlatSpec, FunSuite}

import list.Problem16and17and18and19._

/*
* @author owie 12/1/15
*
*/
class Problem16and17and18and19Test extends FlatSpec with PropertyChecks with Matchers {

  "drop" should "drop every nth element" in {
    val ls = drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    ls should be(List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
  }

  "split" should "split" in {
    val ls = split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    ls should be((List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  it should "produce Nil as second" in {
    val ls = split(3, List('a, 'b, 'c))
    ls should be((List('a, 'b, 'c), Nil))
  }

  it should "throw error" in {
    a[IllegalArgumentException] should be thrownBy {
      split(4, List('a, 'b, 'c))
    }
  }

  "slice" should "slice" in {
    val ls = slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    ls should be(List('d, 'e, 'f, 'g))
  }

  it should "slice 1,4 when list length is 3" in {
    val ls = slice(1, 3, List('a, 'b, 'c))
    ls should be(List('b, 'c))
  }

  it should "throw error when less than 0 from" in {
    a[IllegalArgumentException] should be thrownBy {
      slice(-1, 3, List('a, 'b, 'c))
    }
  }

  it should "throw error when to > list length" in {
    a[IllegalArgumentException] should be thrownBy {
      slice(1, 4, List('a, 'b, 'c))
    }
  }

  it should "throw error when from > to" in {
    a[IllegalArgumentException] should be thrownBy {
      slice(3, 1, List('a, 'b, 'c))
    }
  }

  it should "throw error when from > list length" in {
    a[IllegalArgumentException] should be thrownBy {
      slice(4, 5, List('a, 'b, 'c))
    }
  }

  "rotate" should "rotate" in {
    val ls = rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    ls should be(List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
  }

  it should "rotate at negative index" in {
    val ls = rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    ls should be(List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
  }
}
