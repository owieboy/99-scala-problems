package list

import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.prop.PropertyChecks

import list.Problem12and13and14and15._

/*
* @author owie 12/1/15
*
*/
class Problem12and13and14and15Test extends FlatSpec with PropertyChecks with Matchers {
  "decode" should "decode" in {
    val ls = decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
    ls should be(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }

  "decodeFoldLeft" should "decode" in {
    val ls = decodeFoldLeft(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
    ls should be(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }

  "decodeFlatMap" should "decode" in {
    val ls = decodeFlatMap(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
    ls should be(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }

  "encodeDirect" should "encodeDirect" in {
    val ls = encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    ls should be(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  }

  "duplicate" should "duplicate" in {
    val ls = duplicate(List('a, 'b, 'c, 'c, 'd))
    ls should be(List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
  }

  "duplicateN" should "duplicate N times" in {
    val ls = duplicateN(3, List('a, 'b, 'c, 'c, 'd))
    ls should be(List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
  }
}
