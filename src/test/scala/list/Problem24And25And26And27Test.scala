package list

import org.scalatest.prop.PropertyChecks
import org.scalatest.{Matchers, FlatSpec, FunSuite}

import list.Problem24and25and26and27._

/*
* @author owie 12/2/15
*
*/
class Problem24And25And26And27Test extends FlatSpec with PropertyChecks with Matchers {

  "lotto" should "lotto" in {
    val ls = lotto(6, 49)
    ls.length should be(6)
    ls.distinct.length should be(6)
  }

  "randomPermute" should "randomPermute" in {
    val origList = List('a, 'b, 'c, 'd, 'e, 'f)
    val ls = randomPermute(origList)
    ls.length should be(origList.length)
    ls.distinct.length should be(origList.length)
    ls foreach {
      elem => origList should contain(elem)
    }
  }

  "combinations" should "produce combinations" in {
    val ls = combinations(3, List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
    ls.length should be(220)
  }

  it should "produce 3 in 3C2" in {
    val ls = combinations(2, List(1, 2, 3))
    ls should contain(List(1, 2))
    ls should contain(List(1, 3))
    ls should contain(List(2, 3))
    ls.length should be(3)
  }

  "combinations2" should "produce combinations" in {
    val ls = combinations2(3, List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
    ls.length should be(220)
  }

  it should "produce 3 in 3C2" in {
    val ls = combinations2(2, List(1, 2, 3))
    ls should contain(List(1, 2))
    ls should contain(List(1, 3))
    ls should contain(List(2, 3))
    ls.length should be(3)
  }
}
